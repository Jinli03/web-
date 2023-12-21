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
</head>
<body>
<h1>投诉消息</h1>

<c:forEach var="complaint" items="${complaints}">
    <c:if test="${complaint.replied eq 0}">
        <!-- 这里是当 replied 的值为 0 时执行的内容 -->
        <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
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

        // 如果你希望页面不跳转，可以返回 false；如果要继续提交表单，返回 true
        return true;
    }
</script>
</body>
</html>