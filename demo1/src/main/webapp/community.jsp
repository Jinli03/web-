<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
<%--    欢迎你${username}师生--%>
    <title>交流社区 - 学校食堂点评系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            color: #333;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px 0;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            overflow: hidden;
            margin: 0;
        }

        nav ul li {
            float: left;
        }

        nav ul li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        nav ul li a:hover {
            background-color: #555;
        }

        main {
            margin: 15px;
        }

        section {
            background-color: white;
            padding: 10px;
            margin-bottom: 15px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
        }

        form {
            margin-top: 10px;
        }

        form input[type="text"],
        form textarea,
        form input[type="file"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            width: 100%;
            background-color: orange;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form button:hover {
            background-color:royalblue;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: relative;
            bottom: 0;
            width: 100%;
        }

        .post {
            border-bottom: 1px solid #eee;
            padding: 15px;
            margin-bottom: 15px;
        }
        .like-button {
            background-color: #ffc0cb; /* 粉色背景 */
            border: none; /* 无边框 */
            color: white; /* 白色文字 */
            padding: 15px; /* 足够的填充来形成一个圆 */
            border-radius: 50%; /* 圆角边框形成圆形 */
            cursor: pointer; /* 鼠标悬停时的手形光标 */
            outline: none; /* 移除焦点时的轮廓线 */
        }

        .like-button:hover {
            background-color: #ff99aa; /* 鼠标悬停时的背景颜色变深 */
        }

        .like-button:active {
            background-color: #ff7788; /* 鼠标点击时的背景颜色变深 */
        }
    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="tea_stu_admin.jsp">师生专属首页</a></li>

        </ul>
    </nav>
</header>

<main>
    <section id="post-search">
        <h2>搜索帖子</h2>
        <form action="/demo1_war_exploded/SearchPostServlet" method="get">
            <input type="text" name="searchQuery" placeholder="按标题或用户名搜索">
            <button type="submit">搜索</button>
        </form>
    </section>

    <section id="create-post">
        <h2>发表新帖</h2>
        <form action="/demo1_war_exploded/CreatePostServlet" method="post" >
            <input type="text" name="title" placeholder="标题" required>
            <textarea name="content" placeholder="内容" required></textarea>
<%--            <input type="file" name="image">--%>
            <button type="submit">发布</button>
        </form>
    </section>

    <section id="post-list">
        <h2>帖子列表</h2>
        <c:forEach items="${posts}" var="post">
            <div class='post'>
                <h3>${post.title}</h3>
                <p>发布者: ${post.author}</p>
                <p>内容: ${post.content}</p>
                <p>发布时间: <fmt:formatDate value="${post.datePosted}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
                <p>点赞数: ${post.likes}</p>
                <!-- 点赞表单 -->
                <form id="likeForm-${post.id}" action="/demo1_war_exploded/LikePostServlet" method="post" style="display: none;">
                    <input type="hidden" name="postId" value="${post.id}">
                </form>
                <button class="like-button" onclick="document.getElementById('likeForm-${post.id}').submit();"></button>

                <!-- 查看评论链接 -->
                <a href="/demo1_war_exploded/ViewCommentsServlet?postId=${post.id}">查看评论</a>
            </div>
        </c:forEach>
    </section>


</main>

<footer>
    <p>版权所有 &copy; 学校食堂点评系统</p>
</footer>
</body>
</html>

