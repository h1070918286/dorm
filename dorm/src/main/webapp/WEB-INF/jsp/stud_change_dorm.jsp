<%@ page import="com.dorm.controlloer.UserController" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍调整页面</title>
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
            width: 120px;
        }

        input[type="text"] {
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
<!-- 顶部菜单栏 -->
<div>
    <ul>
        <li><a href="/user/stud_change_password">修改密码</a></li>
        <li><a href="/user/stud_change_info">修改个人信息</a></li>
        <li><a href="/user/stud_change_dorm">调宿</a></li>
        <li><a href="/user/stud_leave">请假</a></li>
    </ul>
</div>

<h2>当前宿舍信息</h2>
<p class="current-dorm">${currentDorm}</p>

<h2>宿舍调整</h2>
<form method="post" action="/dorm/submit">
    <label for="dorm_old">原始宿舍:</label>
    <input type="text" id="dorm_old" name="dorm_old" required />
    <br/>

    <label for="dorm_new">新宿舍:</label>
    <input type="text" id="dorm_new" name="dorm_new" required />
    <br/>

    <label for="reason">调整原因:</label>
    <input type="text" id="reason" name="reason" required />
    <br/>

    <input type="submit" value="提交" />
</form>

<h2>调整记录</h2>
<table>
    <tr>
        <th>原始宿舍</th>
        <th>新宿舍</th>
        <th>调整原因</th>
        <th>是否批准</th>
    </tr>
    <c:forEach items="${adjustmentRecords}" var="record">
        <tr>
            <td>${record.dorm_old}</td>
            <td>${record.dorm_new}</td>
            <td>${record.reason}</td>
            <td>${record.permit}</td>
        </tr>
    </c:forEach>
    <h2>${msg}</h2>
</table>
</body>
</html>