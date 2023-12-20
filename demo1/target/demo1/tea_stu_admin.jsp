<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="select.NewsService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学校食堂点评系统</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        header {
            background-color:palevioletred;
            color: white;
            padding: 10px 0;
        }

        nav ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
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
            background-color: deeppink;
        }

        main {
            margin: 15px;
        }

        footer {
            background-color: #333;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

    </style>

</head>
<body>
<header>
    <nav>
        <ul>

            <li><a href="/demo1_war_exploded/GetAllPostsServlet">交流社区</a></li>
            <li><a href="/demo1_war_exploded/SelectAllDishesByServlet">菜品检索</a></li>
            <li><a href="/demo1_war_exploded/SelectAllCanteensByServlet">食堂检索</a></li>
            <li><a href="complaint_form.jsp">投诉系统</a></li>
            <li><a href="real_time_messaging.jsp">实时消息系统</a></li>
            <li><a href="profile.jsp">个人中心</a></li>
            <li><a href="vote.html">投票</a></li>

        </ul>
    </nav>
</header>
<main>
    <section>
        <h1>欢迎来到学校食堂点评系统</h1>
        <p>在这里你可以浏览最新的菜品，参与社区讨论，发表你的见解。</p>
    </section>

    <section id="news">
        <h2>最新消息</h2>
        <%-- 动态内容区域，可以用Java代码从数据库获取数据 --%>
        <%
            // 导入包含getLatestNews方法的类（如果需要）
            // out是JSP内置对象，用于输出内容到页面
            String news = NewsService.getLatestNews(); // 调用方法获取最新消息
            out.println("<p>" + news + "</p>"); // 将消息输出到页面
        %>

    </section>
</main>

<footer>
    <p>版权所有 &copy; 学校食堂点评系统</p>
</footer>
</body>
</html>

