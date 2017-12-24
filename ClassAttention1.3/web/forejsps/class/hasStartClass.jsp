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
    String basePath = "ws://" + InetAddress.getLocalHost().getHostAddress() + ":" + request.getServerPort() + path + "/webSocket/onClass/";
    request.setAttribute("basePath", basePath);
%>
<%--<p>
    <c:url value="${basePath}" var="uidClass">
        <c:param name="classId" value="${classId}"/>
    </c:url>
</p>--%>

<div id="output"></div>
<script>
    jQuery(function () {
        jQuery('#output').qrcode("${basePath}"+"${classId}");
    })
</script>
<%--<p>"${uid}"+"&"+"${dateId}"</p>--%>


<button onclick="closeWebSocket()">Close</button>
<input id="text" type="text" />
<button onclick="send()">Send</button>
<div id="message">
</div>

</body>


<script type="text/javascript">
    var websocket = null;
    websocket = new WebSocket("ws://localhost:8080/webSocket/onClass/${classId}");
    setMessageInnerHTML("ws://localhost:8080/webSocket/onClass/${classId}");
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    }

    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭连接
    function closeWebSocket() {

        var closeJson ={"isStudent": false, "message": "close","classId": ${classId}};
        setMessageInnerHTML(JSON.stringify(closeJson));
        websocket.send(JSON.stringify(closeJson));
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }

    websocket.onclose = function () {
        setMessageInnerHTML("close");
    }

</script>
</html>
