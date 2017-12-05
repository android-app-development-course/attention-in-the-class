<%@ page import="java.net.InetAddress" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/11/24
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../js/jquery.qrcode.min.js"></script>
<head>
    <title>Title</title>
</head>

<body>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + InetAddress.getLocalHost().getHostAddress()+ ":" + request.getServerPort() + path + "/" + "AndroidJoinServlet";
    request.setAttribute("basePath", basePath);
%>
<p>
    <c:url value="${basePath}" var="uidClass">
        <c:param name="uid" value="${uid}"/>
        <c:param name="dateId" value="${dateId}"/>
    </c:url>
</p>

<p>${pageScope.uidClass}</p>
<div id="output"></div>
<script>
    jQuery(function(){
        jQuery('#output').qrcode("${pageScope.uidClass}");
    })
</script>

</body>
</html>
