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
<!-- 顶部菜单栏 -->
<div>
    <ul>
        <li><a href="/user/tea_info">查看学生信息</a></li>
        <li><a href="/user/tea_leave">学生请假审批</a></li>

    </ul>
</div>
<div class="container">
    <h2>辅导员登录</h2>


</div>
</body>
</html>
