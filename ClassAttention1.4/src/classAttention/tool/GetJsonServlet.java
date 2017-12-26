package classAttention.tool;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetJsonServlet extends HttpServlet {

    public static String getJsonFromWeb(HttpServletRequest request) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer("");
        String temp;
        while ((temp = bufferedReader.readLine()) != null) {
            stringBuffer.append(temp);
        }
        bufferedReader.close();
        return stringBuffer.toString();
    }
}
