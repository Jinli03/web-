<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="http://localhost:8080/demo1_war_exploded/resolve" method="post">
    <p>标题：</p>
    <input type="text" name="title" placeholder="请输入标题">
    <p>发表人：${name}</p>
    <input type="hidden" name="name" value="${name}" />
    <p>发表时间：</p>
    <p id="currentTimeDisplay"></p>
    <!-- Add a hidden input field for currenttime -->
    <input type="hidden" name="currenttime" id="currenttime" />
    <script>
        function updateCurrentTime() {
            var currentDate = new Date();
            var formattedDate = currentDate.toLocaleString();
            // Update the content of the element with id "currentTimeDisplay"
            document.getElementById("currentTimeDisplay").innerHTML = formattedDate;
            // Update the value of the hidden input with id "currenttime"
            document.getElementById("currenttime").value = formattedDate;
        }

        // Update the current time every second
        setInterval(updateCurrentTime, 1000);

        // Initial update
        updateCurrentTime();
    </script>
    <p>留言内容：</p>
    <input type="text" name="inf" placeholder="请输入留言内容">
    <input type="submit" id="but" value="发布">
</form>
<h2>Chat Details</h2>

<!-- Iterate through distinctTitles and display details for each title -->
<c:forEach var="title" items="${distinctTitles}">
    <h3>${title}</h3>

    <!-- Fetch chat details for the current title from chatList -->
    <c:forEach var="chat" items="${chatList}">
        <c:if test="${chat.title eq title}">
            <p>Name: ${chat.name}</p>
            <p>Time: ${chat.currenttime}</p>
            <p>Info: ${chat.inf}</p>
            <hr>
        </c:if>
    </c:forEach>
</c:forEach>
</body>
</html>
