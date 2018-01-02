<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2017/12/21
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.qrcode.min.js"></script>
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
        .row {
            margin-right: -15px;
            margin-left: 60px;
        }
        .col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
            position: relative;
            min-height: 1px;
            padding-right: 20px;
            padding-left: 20px;
        }
        .table {
            max-width: 100%;
            background-color: transparent;
            font-family:"Microsoft Yahei";
            color:#FFFFFF;
        }

        .table-hover > tbody > tr:hover > td,
        .table-hover > tbody > tr:hover > th {
            background-color: #f5f5f5;
        }

    </style>

    <script  src="https://unpkg.com/vue"></script>
</head>
<body text="#68228B" onload="setInterval('clock()',1000)">
<c:if test="${user == null}">
    <script>window.location.href='mainpage.jsp'</script>
</c:if>
<header class="top">

    <nav class="gongneng">
        <img class="headerLogo" width="210px" height="53px" src="../images/headerlogo.png"
             alt="Starbuzz Coffee header logo image">
        <ul >
            <c:if test="${user != null}">
                <li><a href="">历史课堂</a></li>
            </c:if>
        </ul>
    </nav>

</header>
<div >
    <div class="one">
        <table >
            <tr>
                <td><div id="output"></div> </td>
                <script>
                    jQuery(function(){
                        jQuery('#output').qrcode("http://jetienne.com");
                    })
                </script>
                <td><div class="row">
                    <div class="col-md-6">
                        <table class="table table-striped table-bordered table-hover" cellspacing="10px">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>姓名</th>
                                <th>学号</th>
                                <th>时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>张三</td>
                                <td>20152100003</td>
                                <td>11：20</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>李四</td>
                                <td>20152100215</td>
                                <td>11：21</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>赵五</td>
                                <td>20152100152</td>
                                <td>11：21</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>钱七</td>
                                <td>20152100125</td>
                                <td>11：22</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                </td>
            </tr>
            <tr>
                <td><button style="margin-left:7px; margin-top: 15px; width:200px; height: 85px; border-radius: 55px; background:url(../images/结束课程.png); background-size:100% 100% ;outline:none; " ></button></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>