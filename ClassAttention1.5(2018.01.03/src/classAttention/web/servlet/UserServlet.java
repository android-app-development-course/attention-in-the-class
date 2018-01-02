package classAttention.web.servlet;

import classAttention.exception.UserException;
import classAttention.service.UserService;
import classAttention.domain.User;

import yong.tool.commons.CommonUtils;
import yong.tool.mail.Mail;
import yong.tool.mail.MailUtils;
import yong.tool.servlet.BaseServlet;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserService();

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //封装表单 将所有压到map里面
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        form.setHavingClass(-1);
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());

        Map<String, String> errors = new HashMap();
        String username = form.getUsername();
        if (username == null || username.trim().isEmpty())
            errors.put("username", "the username can't be empty");
        else if (username.length() < 3 || username.length() > 12)
            errors.put("username", "the username's length should be 3 to 12");

        String password = form.getPassword();
        if (password == null || password.trim().isEmpty())
            errors.put("password", "the password can't be empty");
        else if (password.length() < 3 || password.length() > 12)
            errors.put("password", "the password's length should be 3 to 12");

        String email = form.getEmail();
        if (email == null || email.trim().isEmpty())
            errors.put("email", "the email can't be empty");
        else if (!email.matches("\\w+@\\w+\\.\\w+"))
            errors.put("email", "please check the email's format");

        String phone = form.getPhone();
        if (phone == null || phone.trim().isEmpty() || !phone.matches("[0-9]*"))
            errors.put("phone", "the password can't be empty or not number");
        else if (phone.length() < 11 || phone.length() > 12)
            errors.put("phone", "the phone's length is not right");


        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "f:/forejsps/user/register.jsp";
        }

        //4.
        try {
            userService.register(form);
        } catch (UserException e) {
            request.setAttribute("message", e.getMessage());
            request.setAttribute("form", form);
            return "f:/forejsps/user/register.jsp";
        }
        //ready properties
        Properties properties = new Properties();
        properties.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("email_template.properties"), "UTF-8"));
        String host = properties.getProperty("host");
        String usernameEmail = properties.getProperty("usernameEmail");
        String passwordEmail = properties.getProperty("passwordEmail");
        String fromEmail = properties.getProperty("fromEmail");
        String subject = properties.getProperty("subject");
        String toEmail = form.getEmail();
        String content = properties.getProperty("content");
        //replace code to (0)
        content = MessageFormat.format(content, form.getCode()); //占位符替换
        System.out.println(content);
        //非常方便地创建了session
        Session session = MailUtils.createSession(host, usernameEmail, passwordEmail);
        Mail mail = new Mail(fromEmail, toEmail, subject, content);
        try {
            MailUtils.send(session, mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        request.setAttribute("message", "congratulation,please check your email and activate your account");
        return "f:/forejsps/message.jsp";
    }

    public String activate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        try {
            userService.activate(code);
            request.setAttribute("message", "激活成功");

        } catch (UserException e) {
            request.setAttribute("message", e.getMessage());
        }
        return "f:/forejsps/message.jsp";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        Map<String, String> errors = new HashMap<>();
        user = userService.login(username,password);
        request.getSession().setAttribute("user", user);
        if (user == null) {
            errors.put("notRight", "用户名或者密码错误");
            request.setAttribute("errors", errors);
            return "f:/forejsps/head.jsp";
        }
        return "f:/forejsps/mainpage.jsp";
    }

    public String loginOut(HttpServletRequest request, HttpServletResponse response){
        request.getSession().invalidate();
        return "f:/forejsps/head.jsp";
    }
}


