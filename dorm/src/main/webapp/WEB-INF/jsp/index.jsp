<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>宿舍管理系统登录</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 80%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button[type="submit"] {
            width: 80%;
            padding: 8px 10px;
            background-color: #4caf50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 30px;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
        select {
            width: 80%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

    </style>
</head>
<body>
<div class="container">
    <h2>宿舍管理系统登录</h2>

    <form action="/user/login" method="post">
        <div class="form-group">
            <label for="name">用户名:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <label>选择登录身份:</label>
        <select id="role" name="role">
            <option value=0>学生</option>
            <option value=2>宿舍管理员</option>
            <option value=1>辅导员</option>
        </select>
        <div>
            <button type="submit">登录</button>
        </div>
    </form>
    <h2>${msg}</h2>
</div>
</body>
</html>
