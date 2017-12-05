package classAttention.android.servlet;

import classAttention.domain.User;
import classAttention.exception.UserException;
import classAttention.service.UserService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import yong.tool.commons.CommonUtils;
import yong.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AndroidUserServlet",urlPatterns = "/AndroidUserServlet")
public class AndroidUserServlet extends BaseServlet {

    private UserService userService = new UserService();

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException {
        //封装表单 将所有压到map里面
        String acceptJson=request.getParameter("androidRegisterForm");
        if (acceptJson==null){
            throw new UserException("未收到注册信息");
        }
        //JsonObject jsonObject = new JsonParser().parse(acceptJson).getAsJsonObject();
        Gson gson=new Gson();
        User form = gson.fromJson(acceptJson,User.class);
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
            gson.toJson(errors);
            return "f:/forejsps/user/register.jsp";
        }

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
}
