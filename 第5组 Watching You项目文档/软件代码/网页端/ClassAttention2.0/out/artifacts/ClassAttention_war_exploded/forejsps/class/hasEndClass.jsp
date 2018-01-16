<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2017/12/30
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../js/jquery.qrcode.min.js"></script>
<link href="../../css/myStyle.css" rel="stylesheet" type="text/css" />
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

    table {
        overflow:hidden;
        border:1px solid #d3d3d3;
        background:#fefefe;
        width:60%;
        margin:5% auto 0;
        margin-top: 55px;
        -moz-border-radius:5px; /* FF1+ */
        -webkit-border-radius:5px; /* Saf3-4 */
        border-radius:5px;
        -moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
        -webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
    }

    th, td {padding:18px 28px 18px; text-align:center; }

    th {padding-top:22px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}

    td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}

    tr.odd-row td {background:#f6f6f6;}

    td.first, th.first {text-align:left}

    td.last {border-right:none;}
    thead  tr {

        display: block;
    }
    tbody {
        display: block;
        height: 500px;
        overflow: auto;
    }
    thead th {
        height: 15px;
        padding-top:10px;
        text-shadow: 1px 1px 1px #fff;
        background:#e8eaeb;
    }
    thead th{
        width:145px;
    }
    thead th +th{
        width:145px;
    }
    thead th +th +th{
        width:145px;
    }
    thead th +th+th+th{
        width:145px;
    }

    /*584*/
    tbody td {
        width:145px;
    }
    tbody td +td{
        width:145px;
    }
    tbody td+td+td {
        width:145px;
    }
    tbody td +td+td+td{
        width:145px;
    }
    /*
    Background gradients are completely unnecessary but a neat effect.
    */

    td {
        background: -moz-linear-gradient(100% 25% 90deg, #fefefe, #f9f9f9);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f9f9f9), to(#fefefe));
    }

    tr.odd-row td {
        background: -moz-linear-gradient(100% 25% 90deg, #f6f6f6, #f1f1f1);
        background: -webkit-gradient(linear, 0% 0%, 0% 25%, from(#f1f1f1), to(#f6f6f6));
    }

    th {
        background: -moz-linear-gradient(100% 20% 90deg, #e8eaeb, #ededed);
        background: -webkit-gradient(linear, 0% 0%, 0% 20%, from(#ededed), to(#e8eaeb));
    }

    /*
    I know this is annoying, but we need additional styling so webkit will recognize rounded corners on background elements.
    Nice write up of this issue: http://www.onenaught.com/posts/266/css-inner-elements-breaking-border-radius

    And, since we've applied the background colors to td/th element because of IE, Gecko browsers also need it.
    */

    tr:first-child th.first {
        -moz-border-radius-topleft:5px;
        -webkit-border-top-left-radius:5px; /* Saf3-4 */
    }

    tr:first-child th.last {
        -moz-border-radius-topright:5px;
        -webkit-border-top-right-radius:5px; /* Saf3-4 */
    }

    tr:last-child td.first {
        -moz-border-radius-bottomleft:5px;
        -webkit-border-bottom-left-radius:5px; /* Saf3-4 */
    }

    tr:last-child td.last {
        -moz-border-radius-bottomright:5px;
        -webkit-border-bottom-right-radius:5px; /* Saf3-4 */
    }

    .myusername{
        float: right;
        padding: 11px 20px 0px 10px;
        font-size: 20px;
        text-align: center;
        text-decoration: none;
        color: #ffffff;
        font-family: Tahoma;
        outline: none;
    }
</style>

<head>
    <meta charset="UTF-8">
    <title>Attention</title>
    <script  src="https://unpkg.com/vue"></script>
</head>

<body >
<header class="top">

    <nav class="gongneng">
        <img class="headerLogo" width="210px" height="53px" src="../../images/headerlogo.png"
             alt="headerLogo">
        <ul>
            <li class="myusername">xuboyong</li>
            <li><a href="historylesson.jsp">历史课堂</a></li>
            <li><a href="${pageContext.request.contextPath }/StartClassServlet?username=${user.username}">我的课堂</a></li>
        </ul>
    </nav>

</header>
<script>
    /*
    function list() {
        //使用jq解析json
        var result=$.parseJSON("${studentInfos}");

        //遍历json
        for(var i=0;i<result.length;i++){
            //增加一行
            var varrow=document.getElementById('student_information').insertRow(nowsrow);

            var one=varrow.insertCell(0);
            var two=varrow.insertCell(1);
            var three=varrow.insertCell(2);
            var four=varrow.insertCell(3);
            one.innerHTML=nowsrow;

            //添加名字
            two.innerHTML=result[i].trueName;
            //添加学号
            three.innerHTML=result[i].schoolId;
            //添加使用情况
          //  four.innerHTML=result[i].endtime;

            nowsrow=nowsrow+1;

            //滑动条最底下
            varrow.scrollTop = varrow.scrollHeight;
        }
        */
    $(document).ready(function () {
        $.ajax({
            url:'http://localhost:8080/HasEndClassServlet?method=endClassList&uid=${user.uid}&classId=${classId}',
            type:'Post',
            dataType:"json",
            success:function (result) {
                var nowsrow=1;//计算当前行数
                //使用js解析jsonarry
                for(var i in result) {
                    //增加一行
                    var varrow = document.getElementById('student_information').insertRow(nowsrow);
                    var one = varrow.insertCell(0);
                    var two = varrow.insertCell(1);
                    var three = varrow.insertCell(2);
                    var four = varrow.insertCell(3);
                    one.innerHTML = result[i].schoolId;

                    //添加名字
                    two.innerHTML = result[i].trueName;


                    //添加使用情况
                    four.innerHTML ="";
                   // var temp=JSON.stringify(result[i].appInfoList);
                    var temp=0;
                    for(var j in result[i].appInfoList)
                    {
                        four.innerHTML=four.innerHTML+result[i].appInfoList[j].appLabel+':';
                        temp= temp+parseInt(result[i].appInfoList[j].appUsedTime);
                        four.innerHTML=four.innerHTML+getDate(result[i].appInfoList[j].appUsedTime);
                    }

                    //添加不在线时间
                    three.innerHTML =getDate(temp);
                    //行数加1
                    nowsrow = nowsrow + 1;
                    //滑动条最底下
                    varrow.scrollTop = varrow.scrollHeight;
                }
            },
            error:function (XMLHttpRequest, textStatus, errorThrown) {
                alert(textStatus);
                alert(errorThrown);
            }

        })
    })
    function getDate(times) {
        var usedTime_H;
        var usedTime_M;
        var usedTime_S;
        usedTime_H = parseInt(times/(60*60*1000));
        usedTime_M =parseInt((times-usedTime_H*(60*60*1000))/(60*1000)) ;
        usedTime_S = parseInt((times-(usedTime_H*60*60*1000)-(usedTime_M*60*1000))/1000);
        return usedTime_H+'时'+usedTime_M+'分'+usedTime_S+'秒'+'<br>';
    }
</script>
<div id="message">

</div>

<div >
    <div>
        <div>
            <table id="student_information" style="height: 400px; overflow:scroll">
                <thead>
                <tr>
                    <th>学号</th>
                    <th>姓名</th>
                    <th>不在线时间</th>
                    <th>使用情况</th>
                </tr>
                </thead>
                <tbody>
                <tr>

                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="one">
    <button onclick="" style="margin-left:35px; margin-top: 60px; width:200px; height: 85px; border-radius: 55px;background:url(../../images/下载数据.png); background-size:100% 100% ;outline:none; " ></button>
</div>
<%--
<form action="/HasEndClassServlet" method="post">
    <input type="hidden" name="method" value="endClassList">
    <input type="hidden" name="classId" value="${classId}">
    <input type="hidden" name="uid" value="${user.uid}">
    <input type="submit" name="submit" onclick="list()" value="submit">
</form>
--%>
</body>
</html>
