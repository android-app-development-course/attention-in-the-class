<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
    欢迎您：${user.username} <a href="${pageContext.request.contextPath }/UserServlet?method=loginOut">退出</a>
    <a href="
    <c:url value="/StartClassServlet">
    <c:param name="username" value="${user.username}"></c:param>
    </c:url>
    ">创建课堂</a>
</c:if>
<%--不知道为什么这个if语句不能用，而且注册语句也不能用--%>
<a href="<c:url value="/UserServlet?method=loginOut"/>">登出</a>
<p>这里有一个创建课堂的按钮 如果点击按钮之后 这里需要写一个判断用户名是否为空的按钮 空的话username=null 不为空username 我目前在登录才设功能</p>

</body>
</html>
