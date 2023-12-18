<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/14
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>提交投诉 - 学校食堂点评系统</title>
    <style>
        /* ... 其他样式 ... */

        form {
            max-width: 500px;
            margin: 20px auto;
            padding: 15px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        form label {
            display: block;
            margin-bottom: 5px;
        }

        form input[type="text"],
        form textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: black;
            color: white;
            cursor: pointer;
        }

        form button:hover {
            background-color: saddlebrown;
        }

        /* ... 更多样式 ... */

    </style>
</head>
<body>
<header>
    <!-- 导航栏内容 -->
</header>

<main>
    <h2>提交投诉</h2>
    <form action="/SubmitComplaintServlet" method="post">
        <label for="complaintTitle">投诉标题:</label>
        <input type="text" id="complaintTitle" name="title" required><br>

        <label for="complaintDetails">详细描述:</label>
        <textarea id="complaintDetails" name="details" required></textarea><br>

        <button type="submit">提交投诉</button>
    </form>
</main>

<footer>
    <!-- 页脚内容 -->
</footer>
</body>
</html>
