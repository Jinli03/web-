<%--
  Created by IntelliJ IDEA.
  User: Popeyeeee
  Date: 2023/12/21
  Time: 12:07
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
            background-image: url('11.jpg'); /* 替换为你的背景图片路径 */
            background-size: cover;
            background-position: center;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            color: #fff; /* 字体颜色为白色 */
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.5); /* 半透明黑色背景 */
            margin: 0;
        }

        div {
            border: 1px solid #ccc;
            padding: 10px;
            margin-bottom: 10px;
            background-color: rgba(255, 255, 255, 0.8); /* 透明白色背景 */
        }

        h2 {
            color: #333; /* 字体颜色为深灰色 */
        }

        p {
            color: #555; /* 字体颜色为灰色 */
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
        }

        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-top: 10px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>投诉消息</h1>

<c:forEach var="complaint" items="${complaints}">
    <c:if test="${complaint.replied eq 0}">
        <div>
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
