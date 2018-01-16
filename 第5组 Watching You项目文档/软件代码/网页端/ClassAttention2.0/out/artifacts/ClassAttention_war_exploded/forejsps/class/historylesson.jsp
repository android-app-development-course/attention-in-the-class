<%--
  Created by IntelliJ IDEA.
  User: xiaoming
  Date: 2018/1/5
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<link href="../css/myStyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.qrcode.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../js/swiper-3.4.0.jquery.min.js" ></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/vue.js"></script>

<style>
    body{
        background-image:url("../images/背景图.jpg");
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
    /*
    Pretty Table Styling
    CSS Tricks also has a nice writeup: http://css-tricks.com/feature-table-design/
    */

    table {
        overflow:hidden;
        border:1px solid #d3d3d3;
        background:#fefefe;
        width:850px;
        margin:5% auto 0;
        -moz-border-radius:5px; /* FF1+ */
        -webkit-border-radius:5px; /* Saf3-4 */
        border-radius:5px;
        -moz-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
        -webkit-box-shadow: 0 0 4px rgba(0, 0, 0, 0.2);
        margin-top: 55px;
    }

    th, td {padding:18px 28px 18px; text-align:center; }

    th {padding-top:10px; height: 15px; text-shadow: 1px 1px 1px #fff; background:#e8eaeb;}

    td {border-top:1px solid #e0e0e0; border-right:1px solid #e0e0e0;}
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
        width:110px;
    }
    thead th +th{
        width:110px;
    }
    thead th +th +th{
        width:110px;
    }
    thead th +th+th+th{
        width:110px;
    }
    thead th +th+th+th+th{
        width:110px;
    }
    /*584*/
    tbody td {
        width:110px;
    }
    tbody td +td{
        width:110px;
    }
    tbody td+td+td {
        width:110px;
    }
    tbody td +td+td+td{
        width:110px;
    }
    tbody td +td+td+td+td{
        width:110px;
    }
    ul li{
        display: inline;
    }
    td ul{
        margin: 0px;
        padding: 0px;
    }

    /*对话框样式*/
    .modal{
        display: none;
        overflow: auto;
        overflow-y: scroll;
        position: fixed;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        z-index: 1050;
        -webkit-overflow-scrolling: touch;
        outline: 0;
    }
    .modal-dialog {
        width: 600px;
        margin: 30px auto;
    }
    .modal-content {
        position: relative;
        background-color: #fff;
        border: 1px solid #999;
        border: 1px solid rgba(0, 0, 0, .2);
        border-radius: 6px;
        -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
        box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
        background-clip: padding-box;
        outline: 0;
    }
    .modal-header {
        padding: 15px;
        border-bottom: 1px solid #e5e5e5;
        min-height: 16.42857143px;
    }
    .modal-header .close {
        margin-top: -2px;
    }
    .modal-title {
        margin: 0;
        line-height: 1.42857143;
    }
    .modal-body {
        position: relative;
        padding: 10px;
    }
    .close {
        float: right;
        font-family: inherit;
        font-size: 21px;
        font-weight: 700;
        line-height: 1;
        color: #000;
        text-shadow: 0 1px 0 #fff;
        opacity: .2;
        filter: alpha(opacity=40);
        font: inherit;
        margin: 0;
        padding: 0;
        cursor: pointer;
        background: 0 0;
        border: 0;
        -webkit-appearance: none;
        margin-top: -2px;
    }
    .text-right {
        text-align: right;
    }
    .btn {
        display: inline-block;
        margin-bottom: 0;
        font-weight: 400;
        text-align: center;
        vertical-align: middle;
        cursor: pointer;
        background-image: none;
        border: 1px solid transparent;
        white-space: nowrap;
        padding: 0px 0px;
        font-size: 14px;
        line-height: 1.42857143;
        border-radius: 4px;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
    .btn-primary {
        color: #fff;
        background-color: #428bca;
        border-color: #357ebd;
    }
    .btn-sm, .btn-group-sm > .btn {
        padding: 5px 13px;
        margin-right: 6px;
        font-size: 12px;
        line-height: 1.5;
        border-radius: 3px;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        /*
        //打开网页时发送消息
        $(document).ready(function () {
            $.ajax({
                url:'服务器地址',
                type:'POST',
                dataType:"json",
                data:data,
                success:function (result) {
                    //使用jq解析json
                    var parsedJSON=jQuery.parseJSON(result);
                    var nowsrow=1;//计算当前行数
                    //遍历json

                    for(var i=0;i<result.length;i++){
                        //增加一行
                        var varrow=document.getElementById('history_information').insertRow(nowsrow);

                        var one=varrow.insertCell(0);
                        var two=varrow.insertCell(1);
                        var three=varrow.insertCell(2);
                        var four=varrow.insertCell(3);
                        one.innerHTML=nowsrow;

                        //添加课堂名称
                        two.innerHTML=result[i].classname;
                        //添加参与人数
                        three.innerHTML=result[i].classname;
                        //添加结束时间
                        four.innerHTML=result[i].endtime;

                        nowsrow=nowsrow+1;

                        //滑动条最底下
                        varrow.scrollTop = varrow.scrollHeight;
                    }
                    document.createStyleSheet();

                }

            })
        })
        */
        window.onload = function(){

            new Vue({
                el:'#box',
                data:{
                    myData:[],
                    Index:"",
                    ClassName:"",
                    People:"",
                    Time:"",
                    nowIndex:-100
                },
                methods:{
                    add:function(){
                        this.myData.push({
                            ClassName:" 111",
                            People:"222 ",
                            Time:"333 "
                        })
                    },
                    del:function(n){
                        if(n ==-2){
                            this.myData="";
                        }{

                            this.myData.splice(n,1);
                        }
                    }
                }
            })
        }
        //添加一行
        function addRow() {
            //增加一行
            var nowsrow=1;
            var varrow=document.getElementById('history_information').insertRow(nowsrow);

            var one=varrow.insertCell(0);
            var two=varrow.insertCell(1);
            var three=varrow.insertCell(2);
            var four=varrow.insertCell(3);
            var five=varrow.insertCell(4);
            one.innerHTML=nowsrow;

            //添加课堂名称
            two.innerHTML="历史";
            //添加参与人数
            three.innerHTML="50";
            //添加结束时间
            four.innerHTML="2015年十月一日";
            //添加按钮图标
            five.innerHTML='<ul>\n' +
                '                <li><img src="../images/Look.png" onclick="Look()" style="width: 40p;height: 40px; margin-right: 15px;"></li>\n' +
                '                <li><img src="../images/Delete.png" alt onclick="Delete()" style="width: 40p;height: 40px;"></li>\n' +
                '            </ul></td>'
            nowsrow=nowsrow+1;

            //滑动条最底下
            varrow.scrollTop = varrow.scrollHeight;
        }
    </script>
</head>
<body>
<header class="top">
    <nav class="gongneng">
        <a href="../mainpage.jsp"><img class="headerLogo" width="210px" height="53px" src="../../images/headerlogo.png"
                                 alt="headerLogo"></a>
    </nav>
</header>
<div id="box">

    <table  id="history_information" style="height: 400px; overflow:scroll" >
        <thead>
        <tr>
            <th>序号</th>
            <th>课堂名称</th>
            <th>参与人数</th>
            <th>课堂时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr  v-for="item in myData">
            <td>{{$index+1}}</td>
            <td>{{item.ClassName}}</td>
            <td>{{item.People}}</td>
            <td>{{item.Time}}</td>
            <td><ul>
                <li><a  onclick=""><img  v-on:click="nowIndex=$index" src="../images/Look.png" style="width: 40p;height: 40px; margin-right: 15px;"></a></li>
                <li><img data-toggle="modal" data-target="#layer" v-on:click="nowIndex=$index" src="../images/Delete.png" style="width: 40p;height: 40px;"></li>
            </ul></td>
        </tr>
        </tbody>
    </table>
    <button v-on:click="add()" style="margin: 100px;">添加</button>
    <!--模态框 弹出框-->
    <div role="dialog" class="modal fade" id="layer" data-index="{{nowIndex}}">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                    <h4 class="modal-title">确认删除吗？</h4>
                </div>
                <div class="modal-body text-right">
                    <button class= "btn btn-danger btn-sm" data-dismiss="modal">取消</button>
                    <button class="btn btn-primary btn-sm" data-dismiss="modal" v-on:click="del(nowIndex)">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>