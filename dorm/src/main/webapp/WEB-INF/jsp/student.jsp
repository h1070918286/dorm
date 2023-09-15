<%@ page import="com.dorm.controlloer.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍管理系统登录</title>
    <style>
        /* 顶部菜单栏样式 */
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #f1f1f1;
        }

        li {
            float: left;
        }

        li a {
            display: block;
            color: #333;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
    </style>
</head>
<body>
<%-- 验证通过后获取用户的身份信息 --%>
<% Integer userId = (Integer) request.getAttribute("userId");%>

<%-- 将用户身份信息保存到会话中 --%>
<% session.setAttribute("userId", userId); %>
<!-- 顶部菜单栏 -->
<div>
    <ul>
        <li><a href="/user/stud_change_password">修改密码</a></li>
        <li><a href="/user/stud_change_info">修改个人信息</a></li>
        <li><a href="/user/stud_change_dorm">调宿</a></li>
        <li><a href="/user/stud_leave">请假</a></li>
    </ul>
</div>
<div class="container">
    <h2>学生登录</h2>

</div>
</body>
</html>
