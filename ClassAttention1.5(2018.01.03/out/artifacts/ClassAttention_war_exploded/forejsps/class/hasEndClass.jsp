<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/12/30
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<form action="/HasEndClassServlet" method="post">
    <input type="hidden" name="method" value="historyClassList"/>
    <input type="hidden" name="uid" value="${user.uid}"/>
    <input type="submit" value="submit">
</form>
<span>${classInfos}</span>
</body>
</html>
