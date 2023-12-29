<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新食堂管理员信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            max-width: 400px;
            margin-top: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form action="/UpdateCanteenManagerServlet" method="post">
    <input type="hidden" name="id" value="${cuser.username}">
    用户名：<input name="username" value="${cuser.username}"><br>
    密码：<input name="password" value="${cuser.password}"><br>
    所属食堂：<input name="canteen" value="${cuser.canteen}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>

