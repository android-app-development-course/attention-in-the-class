<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/11/6
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>注册表单</title>
</head>

<body style="text-align:center;">
<p>${msg}</p>

<form action="${pageContext.request.contextPath}/UserServlet" method="post">
    <input type="hidden" name="method" value="register"/>
    用户名：<input type="text" name="username" value="${form.username}">
    <span>${errors.username}</span><br/>
    密码：<input type="password" name="password" value="${form.password}">
    <span>${errors.password}</span><br/>
    邮箱：<input type="text" name="email" value="${form.email}">
    <span>${errors.email}</span><br/>
    手机：<input type="text" name="phone"><br/>
    <span>${errors.phone}</span><br/>
    <input type="hidden" name="uclassnumber" value="0">
    <input type="submit" value="注册">
</form>
</body>
</html>
