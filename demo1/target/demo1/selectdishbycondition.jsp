<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检索菜品</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        form {
            margin-bottom: 20px;
        }
        input[type="text"], input[type="submit"] {
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #5cb85c;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #449d44;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<form action="http://localhost:8080/demo1_war_exploded/SelectAllDishesByConditionsServlet" method="post" class="inline-form">
    <label for="kind">菜品：</label>
    <input type="text" id="kind" name="kind">

    <label for="price">价格（小于）：</label>
    <input type="text" id="price" name="price">

    <label for="canteen">食堂：</label>
    <input type="text" id="canteen" name="canteen">

    <input type="submit" value="检索">
</form>

<style>
    .inline-form {
        display: flex;
        align-items: center;
        justify-content: space-between;
        flex-wrap: wrap;
        gap: 10px;
    }

    .inline-form label {
        margin-right: 5px;
    }

    .inline-form input[type="text"] {
        padding: 8px;
        margin-right: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .inline-form input[type="submit"] {
        padding: 8px 15px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    .inline-form input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>


<table border="1" cellspacing="0">
    <tr>
        <th>菜名</th>
        <th>菜品</th>
        <th>食堂</th>
        <th>价格</th>
        <th>评分</th>
        <th>图片</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${dishes}" var="item" varStatus="status">
        <tr align="centre">
            <td>${item.id}</td>
            <td>${item.kind}</td>
            <td>${item.canteen}</td>
            <td>${item.price}</td>
            <td>${item.grade}</td>
            <td>${item.picture}</td>
            <td>
                <a href="/demo1_war_exploded/SelectDishByIdServlet?id=${item.id}">评价</a>
                <a href="/demo1_war_exploded/SelectDishCommentByIdServlet?id=${item.id}">查看评价信息</a>
                <a href="/demo1_war_exploded/ComplaintFormServlet?id=${item.id}&canteen=${item.canteen}&dish=${item.id}">提交投诉</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
