<%@ page import="com.dorm.controlloer.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理</title>
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

        /* 搜索表单样式 */
        .search-form {
            margin-bottom: 20px;
        }

        .search-form label {
            display: inline-block;
            width: 120px;
        }

        .search-form input[type="text"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }

        .search-form input[type="submit"] {
            padding: 8px 16px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        /* 修改按钮样式 */
        .edit-button {
            padding: 8px 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        /* 编辑弹窗样式 */
        .edit-popup {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 9999;
            justify-content: center;
            align-items: center;
        }

        .edit-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
        }

        .edit-form label {
            display: inline-block;
            width: 100px;
        }

        .edit-form input[type="text"] {
            width: 200px;
            padding: 5px;
            border: 1px solid #ccc;
        }

        .edit-form input[type="submit"] {
            padding: 8px 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
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
<br>
<form class="search-form" method="post" action="/clean/search">
    <label for="class_room_form">班级:</label>
    <input type="text" id="class_room_form" name="class_room_form" />
    <br/>

    <label for="dorm_room_form">宿舍:</label>
    <input type="text" id="dorm_room_form" name="dorm_room_form" />
    <br/>

    <input type="submit" value="搜索" />
</form>

<table>
    <tr>
        <th>姓名</th>
        <th>密码</th>
        <th>性别</th>
        <th>年龄</th>
        <th>班级</th>
        <th>宿舍号</th>
<%--        <th>操作</th>--%>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.password}</td>
            <td>${student.sex}</td>
            <td>${student.age}</td>
            <td>${student.class_room}</td>
            <td>${student.dorm_room}</td>
<%--            <td><button class="edit-button" onclick="openEditPopup(${student.id}, '${student.name}', '${student.password}', '${student.sex}', ${student.age}, '${student.class_room}', '${student.dorm_room}')">编辑</button></td>--%>
        </tr>
    </c:forEach>
</table>

<h2>${msg}</h2>

</body>
</html>