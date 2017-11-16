<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/11/12
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>classAttention</title>
</head>
<body>
<c:if test="${user==null}">
    <form action="${pageContext.request.contextPath }/UserServlet" method="post">
            <%--这个是用来指向使用的servlet的方法--%>
        <input type="hidden" name="method" value="login"/>
        用户名：<input type="text" name="username">
        密码：<input type="password" name="password">
        <span>${errors.notRight}</span><br/>
        <input type="submit" value="登陆">
        <input type="button" value="注册"
               onclick="javascript:window.parent.body.location.href='${pageContext.request.contextPath }/forejsps/user/register'">
    </form>
</c:if>

<c:if test="${user!=null}">
    欢迎您：${user.username } <a href="${pageContext.request.contextPath }/UserServlet?method=loginOut">退出</a>
</c:if>
<%--不知道为什么这个if语句不能用，而且注册语句也不能用--%>


</body>
</html>
