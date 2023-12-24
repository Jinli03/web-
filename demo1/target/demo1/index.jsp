<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>食堂管理系统登录</title>
    <style>
        body, html {
            height: 100%;
            /* 添加背景图片 */
            background: url('img_5.png') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f7f7f7;
        }
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body, html {
            height: 100%;
            font-family: 'Arial', sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #f7f7f7;
        }

        .login-container {
            padding: 40px;
            background: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            width: 350px;
        }

        .login-container h2 {
            color: #333333;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-input {
            margin-bottom: 20px;
            border: 1px solid #cccccc;
            border-radius: 5px;
            padding: 10px 15px;
            width: 100%;
            font-size: 16px;
        }

        .form-input:focus {
            outline: none;
            border-color: #777777;
        }

        .login-button {
            padding: 10px 15px;
            width: 100%;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-button:hover {
            background-color: #449d44;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>食堂管理系统登录</h2>
    <form action="http://localhost:8080/demo1_war_exploded/LoginServlet" method="post">
        <input type="text" name="username" class="form-input" placeholder="用户名">
        <input type="password" name="password" class="form-input" placeholder="密码">
        <input type="submit" value="登录" class="login-button">
    </form>
</div>
</body>
</html>

