package classAttention.android.servlet;

import classAttention.dao.ResearchDao;
import classAttention.domain.Research;
import classAttention.exception.GetFoundException;
import classAttention.service.ResearchService;
import classAttention.tool.GetJsonServlet;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AndroidJoinResearchServlet",urlPatterns = "/AndroidJoinResearchServlet")
public class AndroidJoinResearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceptJson = GetJsonServlet.getJsonFromWeb(request);
        ResearchService researchService = new ResearchService();
        System.out.println(acceptJson);
        if ( acceptJson == null) {
            try {
                throw new GetFoundException("未收到问卷");
            } catch (GetFoundException e) {
                e.printStackTrace();
            }
        }
        //ResearchDao researchDao = new ResearchDao();
        //String returnData;
        Research  research = new Gson().fromJson(acceptJson,Research.class);
        researchService.addResearchInfo(research);

        response.getOutputStream().write("successful".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
