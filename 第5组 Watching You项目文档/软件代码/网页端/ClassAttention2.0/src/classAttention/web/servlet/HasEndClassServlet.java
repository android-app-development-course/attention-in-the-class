package classAttention.web.servlet;

import classAttention.dao.StudentInfoDao;
import classAttention.domain.ClassInfo;
import classAttention.domain.StudentInfo;
import classAttention.domain.StudentInfoInSql;
import classAttention.service.ClassService;
import classAttention.service.StudentInfoService;
import classAttention.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import yong.tool.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HasEndClassServlet", urlPatterns = "/HasEndClassServlet")
public class HasEndClassServlet extends RootServlet {
    UserService userService = new UserService();
    ClassService classService = new ClassService();
    StudentInfoService studentInfoService = new StudentInfoService();

    public String endClassList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        int classId = Integer.parseInt(request.getParameter("classId"));
        userService.havingClass(uid, -1);
        System.out.println(studentInfoService.getStudentInfoJsonByClassId(classId));
        //response.setContentType("application/json;charset=utf-8");
        //System.out.println(new Gson().toJson(studentInfoInSqls));
        /*request.setAttribute("studentInfos",studentInfoInSqls);
        return "f:/forejsps/class/hasEndClass.jsp";*/
        /*response.getWriter().print(new Gson().toJson(studentInfoInSqls).toString());
        response.getWriter().close();*/
        /*request.getSession().setAttribute("studentInfos", new Gson().toJson(studentInfoInSqls));
        return "f:/forejsps/class/hasEndClass.jsp";*/

        return "A:" +studentInfoService.getStudentInfoJsonByClassId(classId);
    }

    public String historyClassList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");

        List<ClassInfo> classInfos = classService.getByUid(uid);

        //request.setAttribute("classInfos",classInfos);
        //return "f:/forejsps/class/hasEndClass.jsp";
        return "A:" + new Gson().toJson(classInfos);
    }

    public String studentInfosByClassId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));

        /*List<StudentInfoDao> studentInfos = new ArrayList<>();
        studentInfos = studentInfoService.getStudentInfoByClassId(classId);

        for (int i=0;i<studentInfos.size();i++){
            while (studentInfos.get(i).getAppInfoList().size()>2)
            studentInfos.get(i).getAppInfoList().remove(studentInfos.get(i).getAppInfoList().size());
        }
        request.setAttribute("classInfos",studentInfos);*/
        return "f:/forejsps/class/hasEndClass.jsp";
        //return "A:" + new Gson().toJson(studentInfos);

    }

    public String studentInfosBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String studentInfoJson = studentInfoService.getStudentInfoBySid(sid);
        return "A:"+new Gson().toJson(studentInfoJson);
    }
}

