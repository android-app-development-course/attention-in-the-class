package classAttention.web.servlet;

import classAttention.domain.ClassInfo;
import classAttention.domain.StudentInfo;
import classAttention.service.ClassService;
import classAttention.service.StudentInfoService;
import classAttention.service.UserService;
import com.google.gson.Gson;

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

    protected String endClassList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        int classId = Integer.parseInt(request.getParameter("classId"));

        userService.havingClass(uid, -1);
        List<StudentInfo> studentInfos = new ArrayList<>();
        studentInfos = studentInfoService.getStudentInfoByClassId(classId);
        return "A:" + new Gson().toJson(studentInfos);
    }

    protected String historyClassList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");

        List<ClassInfo> classInfos = new ArrayList<>();
        classInfos = classService.getByUid(uid);

        return "A:" + new Gson().toJson(classInfos);
    }

    protected String studentInfosByClassId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int classId = Integer.parseInt(request.getParameter("classId"));

        List<StudentInfo> studentInfos = new ArrayList<>();
        studentInfos = studentInfoService.getStudentInfoByClassId(classId);

        for (int i=0;i<studentInfos.size();i++){
            while (studentInfos.get(i).getAppInfoList().size()>2)
            studentInfos.get(i).getAppInfoList().remove(studentInfos.get(i).getAppInfoList().size());
        }
        return "A:" + new Gson().toJson(studentInfos);

    }

    protected String studentInfosBySid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String studentInfoJson = studentInfoService.getStudentInfoBySid(sid);
        return "A:"+new Gson().toJson(studentInfoJson);
    }
}

