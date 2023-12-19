<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/16
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<h1>搜索结果</h1>
<c:forEach items="${posts}" var="post">
    <div>
        <h2>${post.title}</h2>
        <p>${post.content}</p>
        <p>By: ${post.author}</p>
        <p>On: ${post.datePosted}</p>
        <p>点赞数: ${post.likes}</p>

        <!-- 查看评论链接 -->
        <a href="viewComments.jsp?postId=${post.id}">查看评论</a>
    </div>
</c:forEach>
</body>
</html>
