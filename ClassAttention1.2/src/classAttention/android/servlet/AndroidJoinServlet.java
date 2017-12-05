package classAttention.android.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

@WebServlet(name = "AndroidJoinServlet", urlPatterns = "/AndroidJoinServlet")
public class AndroidJoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=utf-8");
        //request.setCharacterEncoding("UTF-8");

        try {
            /*BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            acceptJson = sb.toString();*/
            OutputStream out = response.getOutputStream();
            String data;
            String acceptJson = request.getParameter("jsonlogin");
            if (acceptJson != null) {
                System.out.print(acceptJson);
                JsonObject jsonObject=new JsonParser().parse(acceptJson).getAsJsonObject();

                data = "true";
            } else data = "false";
            out.write(data.getBytes("utf-8"));
        } catch (
                Exception e)

        {
            // TODO: handle exception
            e.printStackTrace();
        }

        String a = request.getParameter("dateId");
        System.out.print(a);
        a = request.getParameter("uid");
        System.out.print(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
