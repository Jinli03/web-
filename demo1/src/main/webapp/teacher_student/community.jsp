<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/13
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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

   </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="tea_stu_admin.jsp">师生专属首页</a></li>
            <li><a href="/SelectAllDishesByServlet">菜品检索</a></li>
            <li><a href="profile.jsp">个人中心</a></li>
        </ul>
    </nav>
</header>

<main>
    <section id="post-search">
        <h2>搜索帖子</h2>
        <form action="/SearchPostsServlet" method="get">
            <input type="text" name="searchQuery" placeholder="按标题或用户名搜索">
            <button type="submit">搜索</button>
        </form>
    </section>

    <section id="create-post">
        <h2>发表新帖</h2>
        <form action="/CreatePostServlet" method="post" enctype="multipart/form-data">
            <input type="text" name="title" placeholder="标题" required>
            <textarea name="content" placeholder="内容" required></textarea>
            <input type="file" name="image">
            <button type="submit">发布</button>
        </form>
    </section>

    <section id="post-list">
        <h2>帖子列表</h2>
        <%-- 这里可以添加Java代码来动态显示帖子列表 --%>
        <%
            // 示例Java代码
            // List<Post> posts = getPosts(); // 获取帖子列表
            // for (Post post : posts) {
            //     out.println("<div class='post'>");
            //     out.println("<h3>" + post.getTitle() + "</h3>");
            //     out.println("<p>发布者: " + post.getAuthor() + "</p>");
            //     out.println("<p>发布时间: " + post.getTimestamp() + "</p>");
            //     out.println("<p>点赞数: " + post.getLikes() + "</p>");
            //     out.println("</div>");
            // }
        %>
    </section>
</main>

<footer>
    <p>版权所有 &copy; 学校食堂点评系统</p>
</footer>
</body>
</html>