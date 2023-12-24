<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>系统管理员</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f7f7f7;
        }

        nav {
            background-color: #333;
            overflow: hidden;
        }

        nav ul {
            list-style: none;
            padding: 0;
            text-align: center;
        }

        nav ul li {
            display: inline-block;
        }

        nav ul li a {
            display: block;
            padding: 15px 20px;
            color: white;
            text-decoration: none;
            font-size: 18px;
        }

        nav ul li a:hover {
            background-color: #ddd;
            color: black;
        }

        #sys_admin {
            text-align: center;
            padding: 20px;
        }

        footer {
            text-align: center;
            padding: 10px;
            background-color: #333;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>
<nav>
    <ul class="item">
        <li><a href="/demo1_war_exploded/QueryCanteenManagerServlet">查询食堂管理员</a></li>
        <li><a href="/demo1_war_exploded/QueryCanteenServlet">查询食堂</a></li>
        <li><a href="/demo1_war_exploded/QueryCommentServlet">查询评价信息</a></li>
        <li><a href="/demo1_war_exploded/QueryForumServlet">查询论坛信息</a></li>
    </ul>
</nav>

<div id="sys_admin">
    <h1>欢迎你${username}系统管理员</h1>
</div>

<footer>
    <p>版权所有 &copy; 校食堂管理系统</p>
</footer>
</body>
</html>
