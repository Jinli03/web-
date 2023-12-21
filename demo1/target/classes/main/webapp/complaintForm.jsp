<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/20
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        form {
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        h2 {
            color: #333;
        }

        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        textarea {
            height: 100px;
            resize: vertical;
        }

        button[type="submit"] {
            background-color: rebeccapurple;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button[type="submit"]:hover {
            background-color: darkorchid;
        }
    </style>
</head>
<body>
<form action="/demo1_war_exploded/SubmitComplaintServlet" method="post">
    <h2>提交投诉</h2>
    <input type="text" name="title" placeholder="投诉标题" required>
    <textarea name="details" placeholder="详细描述" required></textarea>
    <input type="hidden" name="canteen" value="${canteen}">
    <input type="hidden" name="dish" value="${dish}">
    <button type="submit">提交投诉</button>
</form>

</body>
</html>
