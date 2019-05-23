<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询课程列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/admin.css"/>
</head>
<body>
<div id="top">
    <a href="" class="top_a">ecut网校</a>
    <span id="top_welcome">欢迎管理员:<strong>admin</strong></span>
    <a href="javascript:void(0);" onclick="logout()" class="top_a">退出登录</a>
</div>
<div id="left">
    <a href="${pageContext.request.contextPath }/loginSuccess" class="left_top">导航列表</a>
    <a href="${pageContext.request.contextPath }/users" class="left_middle">用户管理</a>
    <a href="${pageContext.request.contextPath }/courses" class="left_middle" id="left_selected">课程管理</a>
    <a href="${pageContext.request.contextPath }/add" class="left_buttom">添加课程</a>
</div>
<div id="right">
    <form action="${pageContext.request.contextPath }/queryCourses" method="post" name="queryForm">
        <span class="right_text">查询条件：</span>
        <table id="query_table">
            <tr>
                <td>课程名字:<input type="text" name="cname" class="query_text" id="cname"></td>
                <td>课程价格:<input type="text" name="minPrice" class="query_price" id="minPrice">
                    至<input type="text" name="maxPrice" class="query_price" id="maxPrice"></td>
                <td><input type="submit" value="查询" id="query"/></td>
            </tr>
        </table>
    </form>
    <div id="right_bottom">
        <span class="right_text">课程列表：</span>
        <div id="table">
            <c:if test="${empty courseList}">
                <div id="tip">不好意思，查无此课程</div>
            </c:if>
            <c:if test="${not empty courseList}">
            <table>
                <tr id="table_head">
                    <th>课程名</th>
                    <th>课程类型</th>
                    <th>课程价格</th>
                    <th>课程描述</th>
                    <th>课程学习人数</th>
                    <th>权重</th>
                    <th>修改</th>
                </tr>
                <c:forEach items="${courseList }" var="course" varStatus="status">
                    <tr class="table_body">
                        <form action="${pageContext.request.contextPath }/queryCourseById" method="post"
                              name="updateForm">
                            <td>${course.cname}</td>
                            <td>${course.ctype}</td>
                            <td>${course.price}</td>
                            <td>
                                <div id="brief">${course.brief }</div>
                            </td>
                            <td>${course.studycount }</td>
                            <td>${course.weight}</td>
                            <td>
                                <input type="hidden" value="${course.id}" class="id" name="id"/>
                                <input value="修改" type="submit">
                            </td>
                        </form>
                        <td><a href="${pageContext.request.contextPath }/deleteCourse/${course.id}"
                               class="del">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
</div>
<script src="webjars/jquery/3.4.0/jquery.js"></script>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
    function logout() {
        var logout = confirm("您真的确定要退出吗？\n\n请确认！")
        if (logout){
            $.cookie('loginAdmin', '', {path: '/'});
            window.location.href = "${pageContext.request.contextPath }/logout";
        }
    }
    window.onload = function () {
        var i;
        var query = document.getElementById("query");
        query.onclick = function () {
            if (document.queryForm.cname.value === "" && document.queryForm.minPrice.value === ""
                && document.queryForm.maxPrice.value === "") {
                alert("查询条件不能为空!");
                document.queryForm.cname.focus();
                return false;
            }
            if(document.queryForm.minPrice.value !== "" && !(/^([1-9][0-9]*)+(.[0-9]{1,2})?$/.test($("#minPrice").val()))){
                alert("请保证课程最小价格为非零开头的最多带两位小数的数字");
                // document.queryForm.minPrice.text("");
                document.queryForm.minPrice.focus();
                return false;
            }
            if(document.queryForm.maxPrice.value !== "" && !(/^([1-9][0-9]*)+(.[0-9]{1,2})?$/.test($("#maxPrice").val()))){
                alert("请保证课程最大价格为非零开头的最多带两位小数的数字");
                // document.queryForm.maxPrice.text("");
                document.queryForm.maxPrice.focus();
                return false;
            }
        }
        var delList = document.getElementsByClassName("del");
        for (i = 0; i < delList.length; i++)
            delList[i].onclick = function () {
                var msg = "您真的确定要删除吗？\n\n请确认！";
                return confirm(msg);
            }
    }
</script>

</body>

</html>