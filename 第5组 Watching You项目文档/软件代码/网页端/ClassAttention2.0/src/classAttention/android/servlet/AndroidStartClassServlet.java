package classAttention.android.servlet;

import classAttention.domain.ClassInfo;
import classAttention.service.ClassService;
import classAttention.service.UserService;
import classAttention.tool.GetJsonServlet;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "AndroidStartClassServlet", urlPatterns = "/AndroidStartClassServlet")
public class AndroidStartClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService = new ClassService();
        UserService userService = new UserService();
        String uid = GetJsonServlet.getJsonFromWeb(request);
        System.out.println(uid);
        //JsonObject jsonObject = new JsonParser().parse(acceptJson).getAsJsonObject();
        //String uid =  request.getParameter("uid");
        String basePath = "ws://" + InetAddress.getLocalHost().getHostAddress() + ":" + request.getServerPort() + request.getContextPath() + "/webSocket/onClass/";
        if (userService.getUserByUid(uid).getHavingClass() == -1) {
            Timestamp timeStamp = new Timestamp(new Date().getTime());
            ClassInfo classInfo = new ClassInfo();
            classInfo.setUid(uid);
            classInfo.setStartClassTime(timeStamp);
            classService.startClass(classInfo);
            response.getOutputStream().write((basePath + classService.getClassInfo(uid, timeStamp).getClassId()).getBytes("utf8"));
        } else
            response.getOutputStream().write((basePath + userService.getUserByUid(uid).getHavingClass()).getBytes("utf8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
