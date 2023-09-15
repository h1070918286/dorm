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
        <li><a href="/clean/mag_info">学生信息</a></li>
        <li><a href="/clean/mag_dorm">调宿审批</a></li>
        <li><a href="/clean/mag_clean">卫生评分</a></li>
        <li><a href="/clean/mag_leave">请假</a></li>
    </ul>
</div>
<div class="container">
    <h2>宿舍管理员登录</h2>


</div>
</body>
</html>
