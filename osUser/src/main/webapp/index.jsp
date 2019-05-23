<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css"/>
</head>

<body>
<div id="topd">
    <a href="${pageContext.request.contextPath }/getUserAndCourse" id="topa1">ecut网校</a>
    <c:if test="${empty user}">
        <a href="${pageContext.request.contextPath }/entryLogin" id="topa2">登录</a>
        <span class="tops">|</span>
        <a href="${pageContext.request.contextPath }/entryRegister" class="topa">注册</a>
    </c:if>
    <c:if test="${not empty user}">
        <span id="topa2">欢迎您：<strong>
            <a href="${pageContext.request.contextPath }/user" class="topa">${user.username}</a>
        </strong></span>
        <span class="tops">|</span>
        <a href="javascript:void(0);" onclick="logout()" class="topa">退出</a>
    </c:if>
</div>

<div id="topd1">
    <img src="images/11.jpg" id="topd1_i">
    <div id="topd1_d1">
        <a href="${pageContext.request.contextPath }/courseType/java" class="topd1_a">java</a>
        <a href="${pageContext.request.contextPath }/courseType/html" class="topd1_a">html</a>
        <a href="${pageContext.request.contextPath }/courseType/mysql" class="topd1_a">mysql</a>
        <a href="${pageContext.request.contextPath }/courseType/spring" class="topd1_a">spring</a>
    </div>
    <div id="topd1_d2">
        <form id="middle_form" method="post"
              action="${pageContext.request.contextPath }/queryCourse">
            <input type="text" id="cname" name="cname">
            <input type="text" style="display: none">
        </form>
    </div>
</div>

<div id="topd3">
    <div class="d2">
        <div class="d1">
            <div class="carousel">
                <div><a href="${pageContext.request.contextPath }/course/1"><img src="images/12.jpg"/></a></div>
                <div><a href="${pageContext.request.contextPath }/course/2"><img src="images/13.jpg"/></a></div>
                <div><a href="${pageContext.request.contextPath }/course/5"><img src="images/14.jpg"/></a></div>
                <div><a href="${pageContext.request.contextPath }/course/4"><img src="images/15.jpg"/></a></div>
            </div>
        </div>
        <div class="carousel_retu">
            <button class="retu"></button>
        </div>
        <div class="carousel_next">
            <button class="next"></button>
        </div>
    </div>
    <div id="topd3_d">
        <a href="${pageContext.request.contextPath }/courseType/java" class="topd3_a">java</a>
        <a href="${pageContext.request.contextPath }/courseType/html" class="topd3_a">html</a>
        <a href="${pageContext.request.contextPath }/courseType/mysql" class="topd3_a">mysql</a>
        <a href="${pageContext.request.contextPath }/courseType/spring" class="topd3_a">spring</a>
    </div>
</div>

<div id="mid">

    <div class="mid_d">
        <h2>课程</h2>
        <div style="margin-top: 20px;">
            <div class="mid_p"></div>
            <div style="display: inline-block;width: 992px">
                <c:forEach items="${courseList}" var="course" varStatus="status">
                    <div class="mid_i" style="margin-bottom: 14px;">
                        <a href="${pageContext.request.contextPath }/course/${course.id}">
                            <img src="${pageContext.request.contextPath }/images/${course.picture}" alt="">
                            <h5 style="margin-top: 10px">${course.cname}</h5>
                        </a>
                        <h6 style="margin-top: 6px">${course.ctype}</h6>
                        <p class="price"><span style="color:#ff6700;">${course.price}&nbsp学习币</span></p>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</div>
<script src="webjars/jquery/3.4.0/jquery.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    (function () {
        var carousel = document.querySelector(".carousel");
        var img = carousel.querySelectorAll("div");
        var len = img.length;
        carousel.style.left = "0%";
        var retu = document.querySelector(".retu");
        var next = document.querySelector(".next");
        var i = 0;
        next.onclick = function () {
            var left = carousel.style.left;
            if (i < len - 1) {
                carousel.style.left = (parseInt(left) - 100) + "%";
                i++;
            }
            else if (i == len - 1) {
                carousel.style.left = "0%";
                i = 0;
            }
        };
        retu.onclick = function () {
            var left = carousel.style.left;
            if (i > 0) {
                carousel.style.left = (parseInt(left) + 100) + "%";
                i--;
            } else if (i == 0) {
                carousel.style.left = -300 + "%";
                i = len - 1;
            }
        };
    }());

    function logout() {
        var logout = confirm("您真的确定要退出吗？\n\n请确认！");
        if (logout) {
            $.cookie('login', '', {path: '/'});
            window.location.href = "${pageContext.request.contextPath }/logout";
        }
    }

    $("#cname").keyup(function (event) {
        if (event.keyCode === 13) {
            var query = $("#cname");
            var queryVal = query.val();
            if (queryVal == null || queryVal === undefined || queryVal === "") {
                alert("查询条件不能为空，请输入！");
                query.focus();
                return false;
            }
            $("#middle_form").submit();
        }
    });

    window.onload = function () {
        if ($.cookie('login') !== undefined && $.cookie('login') !== '' && '${user.username}' === '') {
            window.location.href = "${pageContext.request.contextPath }/getUserAndCourse";
        } else if ('${courseList}' === "") {
            window.location.href = "${pageContext.request.contextPath }/getCourse";
        }
    }

</script>
</body>
</html>