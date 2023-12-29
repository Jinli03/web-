<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加食堂管理员</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h3 {
            color: #333;
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
<h3>添加食堂管理员</h3>
<form action="/AddCanteenManagerServlet" method="post">
    用户名：<input name="username"><br>
    密码：<input name="password"><br>
    所属食堂：<input name="canteen"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
