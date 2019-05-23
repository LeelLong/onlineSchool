<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>课程详情</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/chapter.css">
</head>
<body>
<div id="topd">
    <a href="${pageContext.request.contextPath }/getUserAndCourse" id="topa1">ecut网校</a>
    <span id="topa2">欢迎您：<strong>
        <a href="${pageContext.request.contextPath }/user" class="topa">${user.username}</a>
    </strong></span>
    <a href="javascript:void(0);" onclick="logout()" class="topa">退出</a>
</div>
<div class="m1">
    <div id="s1">${course.cname}视频</div>
    <div id="s2">
        <div id="d1">
            <c:forEach items="${chapterList}" var="chapter">
                <div class="v">
                    <a href="${pageContext.request.contextPath }/chapter/${chapter.cid}/${chapter.chid}">${chapter.chname}</a>
                </div>
            </c:forEach>
        </div>
        <div id="d2">
            <div id="chname">
                ${course.cname}---${thisChapter.chname}
            </div>
            <video src="${pageContext.request.contextPath }/video/${thisChapter.video}" preload="metadata"
                   height="600px" width="1000px" controls="controls">
                您的浏览器不支持 video 标签。
            </video>
        </div>
        <div id="return"><a href="${pageContext.request.contextPath }/getUserAndCourse">返回首页</a></div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/webjars/jquery/3.4.0/jquery.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    function logout() {
        var logout = confirm("您真的确定要退出吗？\n\n请确认！")
        if (logout) {
            $.cookie('login', '', {path: '/'});
            window.location.href = "${pageContext.request.contextPath }/logout";
        }
    }
</script>
</body>
</html>