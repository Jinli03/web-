<%--
  Created by IntelliJ IDEA.
  User: 锦里
  Date: 2023/12/29
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>所有菜品</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        .dish {
            background: #fff;
            padding: 20px;
            margin-bottom: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        .dish img {
            width: 100%;
            height: auto;
            border-radius: 5px;
        }
        .title {
            color: #5D6975;
            font-size: 2.4em;
            line-height: 1.4em;
            margin-bottom: 30px;
            text-align: center;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="title">最新推荐菜品</h2>

    <c:forEach var="dish" items="${AllDishes}">
        <div class="dish">
            <img src="${dish.picture}" alt="菜品图片">
            <p>菜名：${dish.id}</p>
            <p>菜系：${dish.kind}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>

