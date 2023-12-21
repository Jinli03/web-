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
<<<<<<< HEAD
            background-color: #cc3732;
            text-align: center;
        }

        h2 {
            color: #333;
            text-align: center;
            padding: 20px;
            background-color: rebeccapurple;
            color: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
=======
            background-color: darkorchid;
>>>>>>> 55cc8a61c9c2079b5fd7214780c46f36499a986b
        }
    </style>
</head>
<body>
<form action="/demo1_war_exploded/SubmitComplaintServlet" method="post">
<<<<<<< HEAD
    <h1 style="text-align: center">提交投诉</h1>
=======
    <h2>提交投诉</h2>
>>>>>>> 55cc8a61c9c2079b5fd7214780c46f36499a986b
    <input type="text" name="title" placeholder="投诉标题" required>
    <textarea name="details" placeholder="详细描述" required></textarea>
    <input type="hidden" name="canteen" value="${canteen}">
    <input type="hidden" name="dish" value="${dish}">
    <button type="submit">提交投诉</button>
</form>

<<<<<<< HEAD

<h2>回复消息</h2>
<c:forEach var="complaint" items="${complaints}">
    <c:if test="${judge.username eq complaint.username}">
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
            <h3>${complaint.title}</h3>
            <p>回复人: ${complaint.responder}</p>
            <p>回复内容: ${complaint.reply}</p>
        </div>
    </c:if>
</c:forEach>

=======
>>>>>>> 55cc8a61c9c2079b5fd7214780c46f36499a986b
</body>
</html>
