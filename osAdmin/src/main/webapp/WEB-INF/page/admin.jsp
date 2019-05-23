<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css"/>
</head>
<body>
<div id="top">
    <a href="" class="top_a">ecut网校</a>
    <span id="top_welcome">欢迎管理员:<strong>admin</strong></span>
    <a href="javascript:void(0);" onclick="logout()" class="top_a">退出登录</a>
</div>
<div id="left">
    <a href="${pageContext.request.contextPath }/loginSuccess" class="left_top" id="left_selected">导航列表</a>
    <a href="${pageContext.request.contextPath }/users" class="left_middle">用户管理</a>
    <a href="${pageContext.request.contextPath }/courses" class="left_middle">课程管理</a>
    <a href="${pageContext.request.contextPath }/add" class="left_buttom">添加课程</a>
</div>
<div id="right">
    <div id="welcome">
        欢迎进入管理页
    </div>
</div>

</body>
<script src="webjars/jquery/3.4.0/jquery.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    function logout() {
        var logout = confirm("您真的确定要退出吗？\n\n请确认！")
        if (logout) {
            $.cookie('loginAdmin', '', {path: '/'});
            window.location.href = "${pageContext.request.contextPath }/logout";
        }
    }
</script>
</html>
