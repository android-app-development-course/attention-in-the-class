package classAttention.android.servlet;

import classAttention.domain.ReturnInfoToAndroid;
import classAttention.domain.User;
import classAttention.exception.UserException;
import classAttention.service.UserService;
import classAttention.tool.GetJsonServlet;
import classAttention.web.servlet.RootServlet;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import yong.tool.commons.CommonUtils;
import yong.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AndroidUserServlet", urlPatterns = "/AndroidUserServlet")
public class AndroidUserServlet extends RootServlet {

    private UserService userService = new UserService();

    public String register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UserException {
        //封装表单 将所有压到map里面
        String acceptJson =GetJsonServlet.getJsonFromWeb(request);
        if ( acceptJson == null) {
            throw new UserException("未收到注册信息");
        }
        //JsonObject jsonObject = new JsonParser().parse(acceptJson).getAsJsonObject();
        System.out.println(acceptJson);
        Gson gson = new Gson();
        User form = gson.fromJson(acceptJson, User.class);
        form.setUid(CommonUtils.uuid());
        form.setCode(CommonUtils.uuid() + CommonUtils.uuid());

        form.setHavingClass(-1);
        form.setTrueName("aa");
        form.setSchoolId("11");

        //Map<String, String> errors = new HashMap();
        List<String> errors = new ArrayList<>();
        String username = form.getUsername();
        if (username == null || username.trim().isEmpty())
            errors.add("the username can't be empty");
        else if (username.length() < 3 || username.length() > 12)
            errors.add("the username's length should be 3 to 12");
        String password = form.getPassword();
        if (password == null || password.trim().isEmpty())
            errors.add("the password can't be empty");
        else if (password.length() < 3 || password.length() > 12)
            errors.add("the password's length should be 3 to 12");

        String email = form.getEmail();
        if (email == null || email.trim().isEmpty())
            errors.add("the email can't be empty");
        else if (!email.matches("\\w+@\\w+\\.\\w+"))
            errors.add("please check the email's format");

        String phone = form.getPhone();
        if (phone == null || phone.trim().isEmpty() || !phone.matches("[0-9]*"))
            errors.add("the password can't be empty or not number");
        else if (phone.length() < 6 /*|| phone.length() > 12*/)
            errors.add("the phone's length is not right");

        try {
            userService.register(form);
        } catch (UserException e) {
            errors.add("username is exist");
            if (errors.size() > 0) {
                JsonObject infoJson = new JsonObject();
                infoJson.addProperty("errors", gson.toJson(errors));
                infoJson.addProperty("form", gson.toJson(form));
                //System.out.println(jsonObject.toString());
                return "A:" + infoJson.toString();
            }
        }

        return "A:successful";
    }

    public String login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String acceptJson = GetJsonServlet.getJsonFromWeb(request);
        User user = null;
        List<String> errors = new ArrayList<>();
        JsonObject jsonObject = new JsonParser().parse(acceptJson).getAsJsonObject();
        String username = jsonObject.get("username").getAsString();
        String password = jsonObject.get("password").getAsString();
        user = userService.login(username,password);
        //request.getSession().setAttribute("user", user);
        if (user == null) {
            Gson gson = new Gson();
            errors.add("用户名或者密码错误");
            JsonObject errorsJson= new JsonObject();
            errorsJson.addProperty("errors", gson.toJson(errors));
            //System.out.println(errors);
            return "A:"+errorsJson;
            //request.setAttribute("errors", errors);
        }
        //System.out.println(new Gson().toJson(user));
        return "A:"+new Gson().toJson(user);
    }
}
