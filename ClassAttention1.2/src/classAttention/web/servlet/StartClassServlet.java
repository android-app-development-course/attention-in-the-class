package classAttention.web.servlet;

import classAttention.service.ClassService;
import yong.tool.servlet.BaseServlet;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StartClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClassService classService=new ClassService();
        //request.getServerName()
        String username = request.getParameter("username");
        String uid = classService.startClassUid(username);
        if (uid!=null){
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String dateId = dateFormat.format(date);
            System.out.print(dateId);
            request.getSession().setAttribute("dateId",dateId);
            request.getSession().setAttribute("uid",uid);
            response.sendRedirect(request.getContextPath()+"/forejsps/class/hasStartClass.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
