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
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AndroidJoinServlet", urlPatterns = "/AndroidJoinServlet")
public class AndroidJoinServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=utf-8");
        //request.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
            StringBuffer sb = new StringBuffer("");
            String temp;
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
            }
            br.close();
            String acceptJson = sb.toString();


            OutputStream out = response.getOutputStream();
            String data;
            //String acceptJson = request.getParameter("users");
            if (acceptJson != null) {
                System.out.print(acceptJson);
                Map<String, String> errors = new HashMap();
                errors.put("username", "the username's length should be 3 to 12");
                errors.put("username222", "the username's length should be 3 to 12");
                JsonObject jsonObject = new JsonParser().parse(acceptJson).getAsJsonObject();
                /*JsonObject jsonObject=new JsonObject();
                jsonObject.addProperty("error",gson.toJson(errors));*/
                System.out.println(gson.toJson(jsonObject));
                System.out.println(jsonObject.toString());
                data = "true";
            } else data = "false";
            out.write(data.getBytes("utf-8"));
        } catch (Exception e)

        {
            // TODO: handle exception
            e.printStackTrace();
        }

        /*String a = request.getParameter("dateId");
        System.out.print(a);
        a = request.getParameter("uid");
        System.out.print(a);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
