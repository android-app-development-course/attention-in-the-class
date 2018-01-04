<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/12/17
  Time: 13:24
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
<div id="output"></div>

<script>
    jQuery(function () {
        jQuery('#output').qrcode("ws://10.243.6.27:8080/websocket/onClass/"+"${classId}");
    })
</script>
</body>
</html>
