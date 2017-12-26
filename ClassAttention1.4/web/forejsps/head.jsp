<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登陆界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="../js/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="../images/login.js"></script>
    <link href="../css/login2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>课堂清单<sup>class</sup></h1>

<div class="login" style="margin-top:50px;">

    <div class="header">
        <div class="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);"
                               tabindex="7" switch style="margin-left:19px">登录</a>
            <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8"
               style="margin-left:25px">注册</a>
            <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>

    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">
        <!--登录-->
        <div class="web_login" id="web_login">
            <div class="login-box">
                <div class="login_form">
                    <form action="${pageContext.request.contextPath }/UserServlet" name="loginform"
                          accept-charset="utf-8" id="login_form" class="loginForm" method="post">
                        <input type="hidden" name="method" value="login"/>
                        <div class="uinArea" id="uinArea">
                            <label class="input-tips" for="u">帐号：</label>
                            <div class="inputOuter" id="uArea">
                                <input type="text" id="u" name="username" class="inputstyle"/>
                            </div>
                        </div>
                        <div class="pwdArea" id="pwdArea">
                            <label class="input-tips" for="p">密码：</label>
                            <div class="inputOuter" id="pArea">
                                <input type="password" id="p" name="password" class="inputstyle"/>
                            </div>
                        </div>
                        <span>${errors.notRight}</span><br/>
                        <div style="padding-left:50px;margin-top:20px;">
                            <input type="submit" value="登 录"
                                   style="width:150px;"
                                   class="button_blue"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--登录end-->
    </div>

    <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
        <form action="${pageContext.request.contextPath }/UserServlet" method="post">
            <input type="hidden" name="method" value="register"/>
            <div class="web_login">
                <ul class="reg_form" id="reg-ul" style="margin-top: 10px">
                    <!--div id="userCue" class="cue">快速注册请注意格式</div-->
                    <li>
                        <label for="user" class="input-tips2">用户名：</label>
                        <div class="inputOuter2">
                            <input type="text" id="user" name="username" maxlength="16" class="inputstyle2"/>
                            <span>${errors.username}</span><br/>
                        </div>

                    </li>

                    <li>
                        <label for="passwd" class="input-tips2">密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="passwd" name="password" maxlength="16" class="inputstyle2"/>
                            <span>${errors.password}</span><br/>
                        </div>

                    </li>
                    <li>
                        <label for="passwd2" class="input-tips2">确认密码：</label>
                        <div class="inputOuter2">
                            <input type="password" id="passwd2" name="password2" maxlength="16"
                                   class="inputstyle2"/>
                        </div>

                    </li>

                    <li>
                        <label for="email" class="input-tips2">邮箱：</label>
                        <div class="inputOuter2">

                            <input type="text" id="email" name="email" maxlength="20" class="inputstyle2"/>
                            <span>${errors.email}</span><br/>
                        </div>

                    </li>
                    <li>
                        <label for="phone" class="input-tips2">电话号码：</label>
                        <div class="inputOuter2">
                            <input type="text" id="phone" name="phone" maxlength="11" class="inputstyle2"/>
                            <span>${errors.phone}</span><br/>
                        </div>
                    </li>
                    <li>
                        <div class="inputArea">
                            <input type="submit" value="注 册"
                                   style="width:150px;"
                                   class="button_blue"/>
                        </div>
                    </li>
                </ul>
            </div>
        </form>
    </div>
    <!--注册end-->
</div>
</body>
</html>
