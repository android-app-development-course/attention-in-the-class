package classAttention.web.servlet;

import classAttention.domain.ClassInfo;
import classAttention.exception.UserException;
import classAttention.service.ClassService;
import classAttention.service.UserService;
import yong.tool.servlet.BaseServlet;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService=new ClassService();
        UserService userService = new UserService();
        //request.getServerName()
        String username = request.getParameter("username");
        String uid = userService.getUser(username).getUid();
        if (uid!=null){
            Date date = new Date();
            Timestamp timeStamp = new Timestamp(date.getTime());
            System.out.println(timeStamp);
            System.out.println(timeStamp.toString());
            SimpleDateFormat dateFormat= new SimpleDateFormat ("yyyyMMddhhmmss");
            String dateId = dateFormat.format(date);
            ClassInfo classInfo = new ClassInfo();
            classInfo.setUid(uid);
            classInfo.setStartClassTime(timeStamp);
            //System.out.print(dateId);
            classService.startClass(classInfo);
            int classId = classService.getClassInfo(uid,timeStamp).getClassId();
            request.getSession().setAttribute("dateId",dateId);
            request.getSession().setAttribute("uid",uid);
            request.getSession().setAttribute("classId",classId);
            response.sendRedirect(request.getContextPath()+"/forejsps/class/hasStartClass.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
