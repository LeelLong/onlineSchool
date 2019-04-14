<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>查询用户列表</title>
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
    <a href="${pageContext.request.contextPath }/users" class="left_middle" id="left_selected">用户管理</a>
    <a href="${pageContext.request.contextPath }/courses" class="left_buttom">课程管理</a>
</div>
<div id="right">
    <form action="${pageContext.request.contextPath }/queryUsers" method="post" name="queryForm">
        <span class="right_text">查询条件：</span>
        <table id="query_table">
            <tr>
                <td>用户名:<input type="text" name="username"></td>
                <td>用户姓名:<input type="text" name="realname"></td>
                <td><input type="submit" value="查询" id="query"/></td>
            </tr>
        </table>
    </form>
    <div id="right_bottom">
        <span class="right_text">用户列表：</span>
        <div id="table">
            <table>
                <tr id="table_head">
                    <td>用户名</td>
                    <td>用户姓名</td>
                    <td>用户性别</td>
                    <td>用户生日</td>
                    <td>用户电话</td>
                    <td>用户QQ</td>
                    <td>权重</td>
                </tr>
                <c:forEach items="${userList }" var="user" varStatus="status">
                    <c:if test="${status.index%2==0}">
                        <tr class="table_body">
                            <td>${user.username }</td>
                            <td>${user.realname }</td>
                            <td>
                                <c:if test="${user.gender == true}">男</c:if>
                                <c:if test="${user.gender == false}">女</c:if>
                            </td>
                            <td>${user.telephone }</td>
                            <td>
                                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>${user.qq }</td>
                            <td>
                                <form action="${pageContext.request.contextPath }/updateWeight" method="post"
                                      name="updateForm"
                                      onsubmit="return beforeSubmitUpdate(this)">
                                    <input type="text" value="${user.weight}"
                                           placeholder="${user.weight}"
                                           name="weight" class="weight">
                                    <input type="hidden" value="${user.id}" class="id" name="id"/>
                                    <input value="修改权重" type="submit" class="updateWeight">
                                </form>
                            </td>
                            <td><a href="${pageContext.request.contextPath }/deleteUser/${user.id}"
                                   class="del">删除</a>
                            </td>
                        </tr>
                    </c:if>
                    <c:if test="${status.index%2==1}">
                        <tr class="table_body">
                            <td>${user.username }</td>
                            <td>${user.realname }</td>
                            <td>
                                <c:if test="${user.gender == true}">男</c:if>
                                <c:if test="${user.gender == false}">女</c:if>
                            </td>
                            <td>${user.telephone }</td>
                            <td>
                                <fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
                            </td>
                            <td>${user.qq }</td>
                            <td>
                                <form action="${pageContext.request.contextPath }/updateWeight" method="post"
                                      name="updateForm"
                                      onsubmit="return beforeSubmitUpdate(this)">
                                    <input type="text" value="${user.weight}"
                                           placeholder="${user.weight}"
                                           name="weight" class="weight">
                                    <input type="hidden" value="${user.id}" class="id" name="id"/>
                                    <input value="修改权重" type="submit" class="updateWeight">
                                </form>
                            </td>
                            <td><a href="${pageContext.request.contextPath }/deleteUser/${user.id}"
                                   class="del">删除</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<script type="text/javascript">
    function beforeSubmitUpdate(form) {
        if (form.weight.value === '') {
            alert('权重不能为空！');
            form.weight.focus();
            return false;
        }
    }

    window.onload = function () {
        var i;
        var query = document.getElementById("query");
        query.onclick = function () {
            if (document.queryForm.username.value === "" && document.queryForm.realname.value === "") {
                alert("查询条件不能为空!");
                document.queryForm.username.focus();
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