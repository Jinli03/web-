<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>用户中心 - 学校食堂点评系统</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f0f0f0;
      margin: 0;
      padding: 0;
      color: #333;
    }

    header {
      background-color: #333;
      color: white;
      padding: 10px 0;
    }

    nav ul {
      list-style: none;
      padding: 0;
      margin: 0;
      text-align: center;
    }

    nav ul li {
      display: inline;
    }

    nav ul li a {
      color: white;
      padding: 10px 15px;
      text-decoration: none;
    }

    nav ul li a:hover {
      background-color: #444;
    }

    main {
      max-width: 800px;
      margin: 20px auto;
      padding: 15px;
      background: white;
      border-radius: 8px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    section {
      margin-bottom: 20px;
    }

    section h2 {
      color: #444;
      margin-bottom: 10px;
    }

    form input[type="text"],
    form input[type="email"] {
      width: calc(100% - 20px);
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ddd;
      border-radius: 4px;
    }

    form button {
      width: 100%;
      padding: 10px;
      border: none;
      border-radius: 4px;
      background-color: rebeccapurple;
      color: white;
      cursor: pointer;
    }

    form button:hover {
      background-color: moccasin;
    }

    footer {
      text-align: center;
      padding: 15px 0;
      background-color: #333;
      color: white;
      position: relative;
      bottom: 0;
      width: 100%;
    }

    /* Responsive layout */
    @media (max-width: 600px) {
      nav ul li {
        display: block;
        margin-bottom: 5px;
      }

      main {
        width: 90%;
        padding: 10px;
      }
    }

  </style>
</head>
<body>
<header>
  <nav>
    <ul>
      <li><a href="/LoadTeaStuAdminPageServlet">首页</a></li>

    </ul>
  </nav>
</header>

<main>
  <section id="profile-management">
    <h2>个人信息管理</h2>
    <form action="/UpdateProfileServlet" method="post">
      <!-- 假设已经有方法从后端获取当前用户信息 -->
      <input type="text" name="username" placeholder="用户名" required>
      <input type="email" name="email" placeholder="邮箱" required>
      <!-- 其他个人信息字段 -->
      <button type="submit">更新信息</button>
    </form>
  </section>

  <section id="activity-level">
    <h2>活跃度显示</h2>
    <%-- 显示用户等级和活跃度 --%>
    <p>等级: <span>用户等级</span></p>
    <p>活跃度: <span>用户活跃度</span></p>
  </section>

  <section id="historical-activity">
    <h2>历史行为</h2>
    <%-- 显示用户的历史评价、帖子和投诉记录 --%>
    <ul>
      <li>评价记录</li>
      <li>帖子记录</li>
      <li>投诉记录</li>
    </ul>
  </section>
</main>

<footer>
  <p>版权所有 &copy; 学校食堂点评系统</p>
</footer>
</body>
</html>

