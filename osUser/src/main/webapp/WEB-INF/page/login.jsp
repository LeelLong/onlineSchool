<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css"/>
</head>
<body>
<div id="topd">
    <a href="${pageContext.request.contextPath }/getCourse" id="topa1">ecut网校</a>
    <a href="${pageContext.request.contextPath }/entryRegister" class="topa">注册</a>
</div>
<div id="middle">
    <div id="middle_head">
        登录
    </div>
    <form id="middle_form">
        账号<br>
        <input type="text" name="username" placeholder="请您输入账号"
               class="middle_text" id="username"><br>
        密码<br>
        <input type="password" name="password" placeholder="请您输入密码"
               class="middle_text" id="password"><br>
        <div id="msg"></div>
        <input type="button" value="登录" id="sub" onclick="login()"/>
    </form>

    <a id="middle_a" href="${pageContext.request.contextPath }/entryRegister">注册 ></a>
</div>
</body>
<script src="webjars/jquery/3.4.0/jquery.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    function login() {
        var username = $("#username");
        var password = $("#password");
        var msg = $("#msg");
        var usernameVal = username.val();
        var passwordVal = password.val();
        msg.text("");
        if (usernameVal == null || usernameVal === undefined || usernameVal === "") {
            msg.text("账号不能为空");
            username.focus();
            return false;
        }
        if (passwordVal == null || passwordVal === undefined || passwordVal === "") {
            msg.text("密码不能为空");
            password.focus();
            return false;
        }
        $.ajax(
            {
                url: "${pageContext.request.contextPath }/login",
                type: "POST",
                data: {'username': usernameVal, 'password': passwordVal},
                dataType: "json",
                success: function (data) {
                    if (data.msg === "") {
                        window.location.href = "${pageContext.request.contextPath }/loginSuccess";
                    } else {
                        msg.text(data.msg);
                        username.focus();
                    }
                }
            });
    }
</script>
</html>
