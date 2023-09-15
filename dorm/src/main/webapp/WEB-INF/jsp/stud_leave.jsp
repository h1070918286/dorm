<%@ page import="com.dorm.controlloer.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>学生请假页面</title>
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
        /* 标题样式 */
        h1 {
            color: #333;
            text-align: center;
        }

        h2 {
            color: #555;
        }

        /* 表单样式 */
        form {
            margin-bottom: 20px;
        }

        label {
            display: inline-block;
            width: 100px;
        }

        input[type="text"],
        input[type="date"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        /* 表格样式 */
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<%--<h1>学生请假页面</h1>--%>
<!-- 顶部菜单栏 -->
<div>
    <ul>
        <li><a href="/user/stud_change_password">修改密码</a></li>
        <li><a href="/user/stud_change_info">修改个人信息</a></li>
        <li><a href="/user/stud_change_dorm">调宿</a></li>
        <li><a href="/user/stud_leave">请假</a></li>
    </ul>
</div>
<!-- 请假表单 -->
<h2>请假申请</h2>
<form method="post" action="/leave/submit">
    <label for="reason">请假原因:</label>
    <input type="text" id="reason" name="reason" required />
    <br/>

    <label for="leave_time">请假时间:</label>
    <input type="text" id="leave_time" name="leave_time" required />
    <br/>

    <input type="submit" value="提交" />
</form>

<!-- 请假记录表格 -->
<h2>请假记录</h2>
<table>
    <tr>
        <th>请假原因</th>
        <th>请假时间</th>
        <th>是否审批</th>
    </tr>
    <c:forEach items="${leaveRecords}" var="record">
        <tr>
            <td>${record.reason}</td>
            <td>${record.leave_time}</td>
            <td>${record.permit}</td>
        </tr>
    </c:forEach>
    <h2>${msg}</h2>
</table>
</body>
</html>