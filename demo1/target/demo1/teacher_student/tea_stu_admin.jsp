<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/11
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

=======
>>>>>>> origin/main
<html>
<head>
    <title>学校食堂点评系统</title>
</head>
<body>
<<<<<<< HEAD
欢迎你${username}师生
<header>

=======
<header>
>>>>>>> origin/main
    <nav>
        <ul>
            <li><a href="index_ts.jsp">首页</a></li>
            <li><a href="community.jsp">交流社区</a></li>
<<<<<<< HEAD
            <li><a href="search.jsp">菜品检索</a></li>
=======
            <li><a href="/demo1_war_exploded/SelectAllDishesByServlet">菜品检索</a></li>
>>>>>>> origin/main
            <li><a href="profile.jsp">个人中心</a></li>
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
            // 示例Java代码
            // String news = getLatestNews(); // 假设这个方法从数据库获取最新消息
            // out.println("<p>" + news + "</p>");
        %>
    </section>
</main>

<footer>
    <p>版权所有 &copy; 学校食堂点评系统</p>
</footer>
</body>
</html>
