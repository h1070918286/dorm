<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍管理系统</title>
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

        /* 修改密码表单样式 */
        h2 {
            color: #333;
        }

        form {
            width: 300px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 14px;
            margin-top: 10px;
            cursor: pointer;
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

<!-- 修改密码表单 -->
<div>
    <h2>修改密码</h2>
    <form action="/user/change" method="post">

        <label for="currentName">当前账户名:</label>
        <input type="password" id="currentName" name="currentName" required><br>

        <label for="currentPassword">当前密码:</label>
        <input type="password" id="currentPassword" name="currentPassword" required><br>

        <label for="newPassword">新密码:</label>
        <input type="password" id="newPassword" name="newPassword" required><br>

        <label for="confirmPassword">确认密码:</label>
        <input type="password" id="confirmPassword" name="confirmPassword" required><br>

        <input type="submit" value="提交">
    </form>
    <h2>${msg}</h2>
</div>
</body>
</html>
