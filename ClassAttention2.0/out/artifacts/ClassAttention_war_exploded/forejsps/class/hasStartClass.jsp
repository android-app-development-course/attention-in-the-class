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
<link href="../../css/myStyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="../../css/myTableStyle.css" type="text/css"/>
<meta name="viewport" content="width=100%; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
<script type="text/javascript" src="../../js/swiper-3.4.0.jquery.min.js" ></script>
<!--<link rel="stylesheet" type="text/css" href="//cdn.bootcss.com/Swiper/3.3.1/css/swiper.min.css">-->
<link rel="stylesheet" href="../../css/swiper-3.2.7.min.css" />
<head>
    <title>Lesson</title>
</head>
<style>
    body{
        background-image:url("../../images/背景图.jpg");
        background-size:100% 100%;
        background-attachment:fixed;
        background-repeat:no-repeat;
        margin:0px;
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

    #content {width:65%; max-width:690px; margin:6% auto 0;}

    /*
    Pretty Table Styling
    CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
    */

    table {
        overflow:hidden;
        border:1px solid #d3d3d3;
        background:#fefefe;
        width:616px;
        margin:5% auto 0;
        -moz-border-radius:5px; /* FF1+ */
        -webkit-border-radius:5px; /* Saf3-4 */
        border-radius:5px;
        -moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
        -webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
        margin-top: 0px;
    }

    th, td {padding:18px 28px 18px; text-align:center; }

    th {padding-top:10px; height: 15px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}

    td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
    thead  tr {

        display: block;
    }
    tbody {
        display: block;
        height: 385px;
        overflow: auto;
    }
    thead th {
        height: 15px;
        padding-top:10px;
        text-shadow: 1px 1px 1px #fff;
        background:#e8eaeb;
    }
    thead th{
        width: 70px;
    }
    thead th +th{
        width: 104px;
    }
    thead th +th +th{
        width: 104px;
    }
    thead th +th+th+th{
        width:106px;
    }
    /*584*/
    tbody td {
        width: 70px;
    }
    tbody td +td{
        width: 104px;
    }
    tbody td+td+td {
        width: 104px;
    }
    tbody td +td+td+td{
        width: 106px;
    }
    .container {
        /*width: 100%;*/
        margin-left: 500px;
        margin-top: 70px;
        max-width: 615px;
        margin-right: 20px;
    }
    .swiper1 {
        width: 100%;
        height:50px;
        background-color: rgba(255, 255, 230, 0.8);
        /*
        background-color:#ffffff;
        */
    }
    .swiper1 .selected {
        color: #ec5566;
        border-bottom: 2px solid #d0d0d0;
    }
    .swiper1 .swiper-slide {
        width:50%!important;
        text-align: center;
        font-size: 16px;
        height: 50px;
        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
        cursor: pointer;
    }
    .swiper2 {
        height:446px;
    }
    .swiper2 .swiper-slide {
        height: 446px;
        text-align: center;
        box-sizing: border-box !important;
        overflow-x: hidden !important;
    }

    /*聊天框样式*/
    #chatBox{
        width: 100%;
        height: 100%;
        background: #ffffff;
    }
    .messagebox{
        min-height: 80px;
        color: #afafaf;
        padding-top: 5px;
        padding-right: 10px;
        padding-left: 10px;
        padding-bottom: 0px;
    }
    .user{
        float: left;
        display: inline;
        height: 45px;
        width: 45px;
        margin-top: 0px;
        margin-right: 5px;
        margin-bottom: 0px;
        margin-left: 0px;
        font-size: 12px;
        line-height: 20px;
        text-align: center;
    }
    .messagetext{
        -moz-border-radius: 5px;
        -webkit-border-radius: 5px;
        border-radius: 5px;
        background-color: #b8d45c;
        text-align:left;
        width: auto;
        max_width:440px;
        height: auto;
        display: block;
        padding: 5px;
        float: left;
        color: #333333;
    }
    .messagetime{
        color: #666;
        text-align:left;
        font-size: 10px;
        width: 240px;

        display: block;
        padding-left: 55px;
    }

</style>

<script  src="https://unpkg.com/vue"></script>
<body>
<header class="top">

    <nav class="gongneng">
        <a href="../mainpage.jsp"><img class="headerLogo" width="210px" height="53px" src="../../images/headerlogo.png"
                                 alt="headerLogo"></a>
    </nav>
</header>
<%
    String path = request.getContextPath();
    String basePath = "ws://" + "10.243.20.37" + ":" + "8080"/*request.getServerPort()*/ + path + "/webSocket/onClass/";
    request.setAttribute("basePath", basePath);
%>

<%
    String outPath = request.getContextPath();
    String baseOutPath = "ws://5108c29d.nat123.net:54515" +outPath+ "/webSocket/onClass/";
    request.setAttribute("baseOutPath", baseOutPath);
%>

<p>
    <c:url value="${basePath}" var="uidClass">
        <c:param name="classId" value="${classId}"/>
    </c:url>
</p>

<div >
    <div style="position:absolute;margin-left: 150px;margin-top:80px;width:200px;height:400px;">
        <div id="control">
            <div id="output" style="width: 256px; height: 256px;"></div>
            <script>
                refresh();
                self.setInterval("refresh()",1000);
                function refresh() {
                    var temp=document.createElement("div");
                    var date=new Date();

                    jQuery(function(){
                        var edit = "${basePath}" + "${classId}" + "&" + date.getTime();
                        jQuery(temp).qrcode(edit);
                    })
                    var control=document.getElementById('control');
                    var now=document.getElementById('output');
                    $("#output").empty();
                    output.appendChild(temp);
                }

            </script>
        </div>
        <div>
            <button onclick="closeWebSocket()" style="margin-left:25px; margin-top: 15px; width:200px; height: 85px; border-radius: 10px; background:url(../../images/结束课程.png); background-size:100% 100% ;outline:none; " ></button>
        </div>
    </div>
    <div class="container">
        <div class="swiper-container swiper1">
            <div class="swiper-wrapper" >
                <div class="swiper-slide selected" style="">课堂名单</div>
                <div class="swiper-slide" style="width:50%!important;">聊天窗口</div>
            </div>
        </div>
        <!-- swiper2 -->
        <div class="swiper-container swiper2">
            <div class="swiper-wrapper">
                <div class="swiper-slide swiper-no-swiping">
                    <div  style="height: 400px;width: 600px;">
                        <table id="login_information" style="height: 400px; overflow:scroll">
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

                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <!--聊天窗口-->
                <div class="swiper-slide  swiper-no-swiping" id="chatBox">
                    <div style="font-size: 40px;text-align: center" >聊天窗口</div>
                </div>
            </div>
        </div>
    </div>
    <div style="margin-right: 30px; float:right; clear: none;">
        <img style="width: 80px;height: 80px;" onclick="ShowAndHide()" src="../../images/二维码按钮.png">
    </div>

    <script>
        $(function() {
            function setCurrentSlide(ele, index) {
                $(".swiper1 .swiper-slide").removeClass("selected");
                ele.addClass("selected");
                //swiper1.initialSlide=index;
            }

            var swiper1 = new Swiper('.swiper1', {
//					设置slider容器能够同时显示的slides数量(carousel模式)。
//					可以设置为number或者 'auto'则自动根据slides的宽度来设定数量。
//					loop模式下如果设置为'auto'还需要设置另外一个参数loopedSlides。
                slidesPerView: 5.5,
                paginationClickable: true,//此参数设置为true时，点击分页器的指示点分页器会控制Swiper切换。
                spaceBetween: 10,//slide之间的距离（单位px）。
                freeMode: true,//默认为false，普通模式：slide滑动时只滑动一格，并自动贴合wrapper，设置为true则变为free模式，slide会根据惯性滑动且不会贴合。
                loop: false,//是否可循环
                onTab: function(swiper) {
                    var n = swiper1.clickedIndex;
                }
            });
            swiper1.slides.each(function(index, val) {
                var ele = $(this);
                ele.on("click", function() {
                    setCurrentSlide(ele, index);
                    swiper2.slideTo(index, 500, false);
                    //mySwiper.initialSlide=index;
                });
            });

            var swiper2 = new Swiper('.swiper2', {
                //freeModeSticky  设置为true 滑动会自动贴合
                direction: 'horizontal',//Slides的滑动方向，可设置水平(horizontal)或垂直(vertical)。
                loop: false,
//					effect : 'fade',//淡入
                //effect : 'cube',//方块
                //effect : 'coverflow',//3D流
//					effect : 'flip',//3D翻转
                autoHeight: true,//自动高度。设置为true时，wrapper和container会随着当前slide的高度而发生变化。
                onSlideChangeEnd: function(swiper) {  //回调函数，swiper从一个slide过渡到另一个slide结束时执行。
                    var n = swiper.activeIndex;
                    setCurrentSlide($(".swiper1 .swiper-slide").eq(n), n);
                    swiper1.slideTo(n, 500, false);
                }
            });
        });
    </script>
    <script>
        //增加一行
        var nowsrow=1;
        function addRow(Message) {
            var varrow=document.getElementById('login_information').insertRow(nowsrow);
            var message = $.parseJSON(Message);
            var one=varrow.insertCell(0);
            var two=varrow.insertCell(1);
            var three=varrow.insertCell(2);
            var four=varrow.insertCell(3);
            one.innerHTML=nowsrow;

            //添加学号
            two.innerHTML=message.userName;
            //添加名字
            three.innerHTML=message.schoolId;
            var d=new Date();
            four.innerHTML=d.getHours()+":"+d.getMinutes();
            nowsrow=nowsrow+1;

            //滑动条最底下
            varrow.scrollTop = varrow.scrollHeight;
        }

        //添加聊天信息
        function addMessage(Message) {
            var varrow=document.getElementById('chatBox');
            var message = $.parseJSON(Message);
            //构建messagebox

            //用户信息
            var user=document.createElement("div");
            user.setAttribute("class","user");
            switch (message.userName){
                case "许博勇":
                    user.innerHTML='<img src="../../images/head1.jpg"  style="max-height: 100%;max_with:100%;">'+"许博勇";
                    break;
                case "孔庆莱":
                    user.innerHTML='<img src="../../images/head2.jpg"  style="max-height: 100%;max_with:100%;">'+"孔庆莱";
                    break;
                case "周锐良":
                    user.innerHTML='<img src="../../images/head3.jpg"  style="max-height: 100%;max_with:100%;">'+"周锐良";
                    break;
                case "周韬锐":
                    user.innerHTML='<img src="../../images/head4.jpg"  style="max-height: 100%;max_with:100%;">'+"周韬锐";
                    break;
                case "张健欣":
                    user.innerHTML='<img src="../../images/head5.jpg"  style="max-height: 100%;max_with:100%;">'+"张健欣";
                    break;
                default :
                    user.innerHTML='<img src="../../images/head1.jpg"  style="max-height: 100%;max_with:100%;">'+"许博勇";
                    break;
            }
            //聊天信息
            var messagetext=document.createElement("div");
            messagetext.setAttribute("class","messagetext");
            messagetext.innerHTML= message.message;
            //获取时间
            var messagetime=document.createElement("span");
            messagetime.setAttribute("class","messagetime");
            var d=new Date();
            messagetime.innerHTML=d.getHours()+":"+d.getMinutes();

            //聊天框
            var messagebox=document.createElement("div");
            messagebox.setAttribute("class","messagebox");
            messagebox.appendChild(user);
            //将时间加入聊天信息中
            messagebox.appendChild(messagetime);
            messagebox.appendChild(messagetext);
            //将聊天框显示
            varrow.appendChild(messagebox);
            //滑动条最底下
            varrow.scrollTop = varrow.scrollHeight;

            /*
            varrow.appendChild(nameandtime);
            */
        }
        //jdk.internal.dynalink.support.AbstractCallSiteDescriptor
        //显示和隐藏二维码
        function ShowAndHide() {
            var div1=document.getElementById("output");
            if(div1.style.display=='block') div1.style.display='none';
            else div1.style.display='block';
        }

    </script>
    <script type="text/javascript">
        var websocket = null;
        websocket = new WebSocket("ws://10.243.20.37:8080/webSocket/onClass/${classId}");
        //setMessageInnerHTML("ws://localhost:8080/webSocket/onClass/${classId}");
        //websocket = new WebSocket("ws://5108c29d.nat123.net:54515/webSocket/onClass/${classId}");
        //setMessageInnerHTML("ws://5108c29d.nat123.net:54515/webSocket/onClass/${classId}");
        //连接发生错误的回调方法
        websocket.onerror = function () {
            //setMessageInnerHTML("error");
        };

        //连接成功建立的回调方法
        websocket.onopen = function (event) {
            //setMessageInnerHTML("open");
        }

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        }

        //连接关闭的回调方法
        websocket.onclose = function () {
            //setMessageInnerHTML("close");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            websocket.close();
        }

        function setMessageInnerHTML(Message) {
            var message = $.parseJSON(Message);
            if(message.schoolId == "")
                addMessage(Message);
            else
                addRow(Message);
            //var varrow=document.getElementById('chatBox');
            //var messagetext=document.createElement("div");
            //messagetext.setAttribute("class","messagetext");
            //messagetext.innerHTML=Message;
            //varrow.appendChild(messagetext);
        }

        //关闭连接
        function closeWebSocket() {

            var closeJson = {"isStudent": false, "message": "close", "classId": ${classId}};
            //setMessageInnerHTML(JSON.stringify(closeJson));
            websocket.send(JSON.stringify(closeJson));
            websocket.close();

            window.location.href='hasEndClass.jsp';
        }

        websocket.onclose = function () {
            //setMessageInnerHTML("close");
        }
    </script>

</div>
</body>
</html>
