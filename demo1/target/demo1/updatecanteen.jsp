<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新食堂信息</title>
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
<form action="/UpdateCanteenServlet" method="post">

    <input type="hidden" name="id" value="${canteen.name}">
    食堂名称：<input name="name" value="${canteen.name}"><br>
    运营时间：<input name="time" value="${canteen.time}"><br>
    位置：<input name="position" value="${canteen.position}"><br>
    <input type="submit" value="提交">

</form>
</body>
</html>
