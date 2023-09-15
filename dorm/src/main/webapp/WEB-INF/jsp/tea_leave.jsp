<%@ page import="com.dorm.controlloer.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>请假审批</title>
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
        /* CSS样式 */
        body {
            font-family: Arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        .button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-top: 10px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #45a049;
        }

        select {
            padding: 8px;
            font-size: 14px;
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
<br>

<form action="/leave/search" method="post">
    <select name="status">
        <option value=0>全部</option>
        <option value=1>未审核</option>
        <option value=2>已审核</option>
    </select>
    <button class="button" type="submit">确定</button>
</form>
<table>
    <tr>
        <th>学生姓名</th>
        <th>理由</th>
        <th>请假时间</th>
        <th>是否批准</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${leaves}" var="leave">
        <tr>
            <td>${leave.name}</td>
            <td>${leave.reason}</td>
            <td>${leave.leave_time}</td>
            <td>${leave.permit}</td>
            <td><button class="button" onclick="sendPermit(${leave.id})">批准</button>
                <button class="button" onclick="sendNoPermit(${leave.id})">否决</button>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>${msg}</h2>
<script>
    function sendPermit(leaveId) {
        // 创建一个XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 设置请求方法和URL
        xhr.open("Post", "/leave/permit?id=" + leaveId, true);

        // 设置请求头
        xhr.setRequestHeader("Content-Type", "application/json");

        // 设置请求的数据
        // var data = {
        //     id: leaveId
        // };

        // 发送请求
        xhr.send();
    }
    function sendNoPermit(leaveId) {
        // 创建一个XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 设置请求方法和URL
        xhr.open("Post", "/leave/noPermit?id=" + leaveId, true);

        // 设置请求头
        xhr.setRequestHeader("Content-Type", "application/json");

        // 设置请求的数据
        // var data = {
        //     id: leaveId
        // };

        // 发送请求
        xhr.send();
    }
</script>
</body>
</html>