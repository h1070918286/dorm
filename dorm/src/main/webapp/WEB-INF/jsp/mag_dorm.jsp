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
<h2>调宿记录</h2>
<form action="/clean/search_dorm" method="post">
    <select name="status">
        <option value=0>全部</option>
        <option value=1>未审核</option>
        <option value=2>已审核</option>
    </select>
    <button class="button" type="submit">确定</button>
</form>
<table>
    <tr>
        <th>姓名</th>
        <th>原始宿舍</th>
        <th>新宿舍</th>
        <th>调整原因</th>
        <th>是否批准</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${adjustmentRecords}" var="record">
        <tr>
            <td>${record.name}</td>
            <td>${record.dorm_old}</td>
            <td>${record.dorm_new}</td>
            <td>${record.reason}</td>
            <td>${record.permit}</td>
            <td><button class="button" onclick="sendPermit(${record.id})">批准</button>
                <button class="button" onclick="sendNoPermit(${record.id})">否决</button>
            </td>
        </tr>
    </c:forEach>
    <h2>${msg}</h2>
</table>
<script>
    function sendPermit(Id) {
        // 创建一个XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 设置请求方法和URL
        xhr.open("Post", "/clean/permit?id=" + Id, true);

        // 设置请求头
        xhr.setRequestHeader("Content-Type", "application/json");

        // 设置请求的数据
        // var data = {
        //     id: leaveId
        // };

        // 发送请求
        xhr.send();
    }
    function sendNoPermit(Id) {
        // 创建一个XMLHttpRequest对象
        var xhr = new XMLHttpRequest();

        // 设置请求方法和URL
        xhr.open("Post", "/clean/noPermit?id=" + Id, true);

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