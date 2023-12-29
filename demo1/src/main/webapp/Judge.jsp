<%--
  Created by IntelliJ IDEA.
  User: 锦里
  Date: 2023/12/29
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Complaints Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 0;
            padding: 0;
            background: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        .complaint-container {
            max-width: 600px;
            margin: 30px auto;
            padding: 20px;
            background: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .complaint {
            border-bottom: 1px solid #eee;
            padding: 10px;
            margin-bottom: 20px;
        }
        .complaint:last-child {
            border-bottom: none;
        }
        button {
            background: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #0056b3;
        }
        textarea {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ddd;
            margin-bottom: 10px;
        }
        input[type="submit"] {
            background: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #218838;
        }
    </style>
</head>
<body>
<h1>食堂评价</h1>

<div class="complaint-container">
    <c:forEach var="complaint" items="${complaints}">
        <c:if test="${complaint.replied eq 0}">
            <div class="complaint">
                <h2>${complaint.title}</h2>
                <p>${complaint.details}</p>
                <button onclick="showReplyForm('${complaint.title}')">回复</button>
                <div id="${complaint.title}_replyForm" style="display: none;">
                    <form action="replyServlet" method="post" onsubmit="return showSuccessMessage()">
                        <input type="hidden" name="title" value="${complaint.title}">
                        <textarea name="reply" rows="3" cols="30" placeholder="请输入你的回复"></textarea>
                        <br>
                        <input type="submit" value="提交回复">
                    </form>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>

<script>
    function showReplyForm(title) {
        var replyForm = document.getElementById(title + '_replyForm');
        replyForm.style.display = 'block';
    }

    function showSuccessMessage() {
        alert("回复成功");
        return true;
    }
</script>
</body>
</html>

