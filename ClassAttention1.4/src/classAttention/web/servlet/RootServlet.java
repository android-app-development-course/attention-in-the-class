package classAttention.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

@WebServlet(name = "RootServlet")
public class RootServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");//处理响应编码
        request.setCharacterEncoding("UTF-8");


        OutputStream out = response.getOutputStream();
        /**
         * 1. 获取method参数，它是用户想调用的方法 2. 把方法名称变成Method类的实例对象 3. 通过invoke()来调用这个方法
         */
        String methodName = request.getParameter("method");
        Method method = null;
        /**
         * 2. 通过方法名称获取Method对象
         */
        try {
            method = this.getClass().getMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("您要调用的方法：" + methodName + "不存在！", e);
        }

        /**
         * 3. 通过method对象来调用它
         */
        try {
            String result = (String)method.invoke(this, request, response);
            if(result != null && !result.trim().isEmpty()) {//如果请求处理方法返回不为空
                int index = result.indexOf(":");//获取第一个冒号的位置
                if(index == -1) {//如果没有冒号，使用转发
                    request.getRequestDispatcher(result).forward(request, response);
                } else {//如果存在冒号
                    String start = result.substring(0, index);//分割出前缀
                    String path = result.substring(index + 1);//分割出路径
                    if(start.equals("f")) {//前缀为f表示转发
                        request.getRequestDispatcher(path).forward(request, response);
                    } else if(start.equals("r")) {//前缀为r表示重定向
                        response.sendRedirect(request.getContextPath() + path);
                    } else if(start.equals("A")){
                        out.write(path.getBytes("utf-8"));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}