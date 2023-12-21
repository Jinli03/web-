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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <p>By: <a href="UserPostsServlet?username=${post.author}">${post.author}</a></p>
        <p>On: ${post.datePosted}</p>
        <p>点赞数: ${post.likes}</p>
        <img src="${pageContext.request.contextPath}/GetImageServlet?postId=${post.id}" alt="Post Image">
        <!-- 评论部分 -->
        <section id="postcomments">
            <!-- 显示现有评论的列表 -->
            <c:forEach items="${commentsMap[post.id]}" var="postcomment">
            <div class="postcomment">
                <p>${postcomment.content}</p>
                <p>By: ${postcomment.username} - On: <fmt:formatDate value="${postcomment.datePosted}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
            </div>
            </c:forEach>
        </section>
    </div>
</c:forEach>
</body>
</html>
