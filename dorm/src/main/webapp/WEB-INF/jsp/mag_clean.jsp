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
    </style>
</head>
<body>
<%--<h1>学生请假页面</h1>--%>
<!-- 顶部菜单栏 -->
<div>
    <ul>
        <li><a href="/clean/mag_info">学生信息</a></li>
        <li><a href="/clean/mag_dorm">调宿审批</a></li>
        <li><a href="/clean/mag_clean">卫生评分</a></li>
        <li><a href="/clean/mag_leave">请假</a></li>
    </ul>
</div>
<!-- 卫生评分表单 -->
<h2>卫生评分</h2>
<form method="post" action="/clean/submit">
    <label for="dorm_room">宿舍号:</label>
    <input type="text" id="dorm_room" name="dorm_room" required />
    <br/>

    <label for="score">评分:</label>
    <input type="text" id="score" name="score" required />
    <br/>

    <label for="reason">说明:</label>
    <input type="text" id="reason" name="reason" required />
    <br/>

    <label for="record_time">评分时间:</label>
    <input type="text" id="record_time" name="record_time" required />
    <br/>

    <input type="submit" value="提交" />
</form>
<br>
<form action="/clean/getByDorm" method="post">
    <label for="search">宿舍号:</label>
    <input type="text" id="search" name="search"/>
    <br/>
    <button class="button" type="submit">搜索</button>
</form>

<!-- 请假记录表格 -->
<h2>卫生评分记录</h2>
<table>
    <tr>
        <th>宿舍号</th>
        <th>评分</th>
        <th>说明</th>
        <th>评分时间</th>
    </tr>
    <c:forEach items="${Records}" var="record">
        <tr>
            <td>${record.dorm_room}</td>
            <td>${record.score}</td>
            <td>${record.reason}</td>
            <td>${record.record_time}</td>
        </tr>
    </c:forEach>
    <h2>${msg}</h2>
</table>
</body>
</html>