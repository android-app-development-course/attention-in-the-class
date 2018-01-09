package classAttention.android.servlet;

import classAttention.domain.StudentInfo;
import classAttention.exception.GetFoundException;
import classAttention.service.StudentInfoService;
import classAttention.tool.GetJsonServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EndClassCollectStudentInfoServlet", urlPatterns = "/EndClassCollectStudentInfoServlet")
public class EndClassCollectStudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceptJson =GetJsonServlet.getJsonFromWeb(request);
        if ( acceptJson == null) {
            System.out.println("未收到注册信息");
        }
        else{
            response.getOutputStream().write("successful".getBytes("utf-8"));
            StudentInfoService studentInfoService = new StudentInfoService();
            StudentInfo studentInfo = new Gson().fromJson(acceptJson,StudentInfo.class);
            //System.out.println(studentInfo.getSchoolId());
            studentInfoService.add(studentInfo);
            System.out.println(acceptJson);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
