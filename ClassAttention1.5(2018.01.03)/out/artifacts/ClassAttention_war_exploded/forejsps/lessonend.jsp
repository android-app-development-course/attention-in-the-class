<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2017/12/21
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Attention</title>
    <style>
        body{
            background-image:url("../images/背景图2.jpg");
            background-size:100% 100%;
            background-attachment:fixed;
            background-repeat:no-repeat;
            margin:0px;
        }
        .div {
            margin: 0;
            padding: 0;
            border: 0;
            outline: 0;
            vertical-align: baseline;
            background: transparent;
        }
        .mybutton{
            width:150px;
            height:60px;
            border:1px;
        }
        .mybutton{
        image(width:100% height:100%;)
        }
        .dimen{
            display: table;
            margin:0 auto;
            margin-top:180px;
        }
        .one{
            display: table;
            margin:0 auto;
            margin-top:160px;
        }
        .top{
            margin:0;
            padding:0;
            background: #ffffff;
            width: 100%;
            height: 55px;
            top: 0;
            position: fixed;
            background-color: rgba(255, 255, 230, 0.25);
        }
        nav ul {
            float:right;
            margin: 5px 0px 0px 0px;
            padding: 0 0 0 0;
            width: 50%;
            list-style: none;
        }
        nav ul li{
            float:right;
        }
        nav ul li a {
            float: right;
            padding: 11px 20px 0px 10px;
            font-size: 20px;
            text-align: center;
            text-decoration: none;
            color: #ffffff;
            font-family: Tahoma;
            outline: none;
        }
        .headerLogo {
            margin-left: 1px;
            float: left;
            outline: none;
        }
        .gongneng{
        }
    </style>

    <script  src="https://unpkg.com/vue"></script>
</head>
<body text="#68228B" onload="setInterval('clock()',1000)">
<c:if test="${user == null}">
    <a href="head.jsp">注册/登陆</a>
</c:if>
<header class="top">

    <nav class="gongneng">
        <img class="headerLogo" width="210px" height="53px" src="../images/headerlogo.png"
             alt="Starbuzz Coffee header logo image">
        <ul >
            <li><a href="">历史课堂</a></li>
            <li><a href="lesson.jsp">我的课堂</a></li>
        </ul>
    </nav>

</header>
<div >
    <div class="one">
        <table >
            <tr>
                <image style="margin-top: 50px" src="images/上课不准玩手机.png"></image>
            </tr>
            <tr>
                <td><button style="margin-left:35px; margin-top: 60px; width:200px; height: 85px; border-radius: 55px;background:url(../images/下载数据.png); background-size:100% 100% ;outline:none; " >

                </button></td>
                <td><button style="margin-left:100px; margin-top: 60px; width:200px; height: 85px; border-radius: 55px; background:url(../images/返回首页.png); background-size:100% 100% ;outline:none; " >

                </button></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
