<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂菜品</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #4CAF50;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<table>
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
        <tr align="center">
            <td>${item.id}</td>
            <td>${item.kind}</td>
            <td>${item.canteen}</td>
            <td>${item.price}</td>
            <td>${item.grade}</td>
            <td>${item.picture}</td>
            <td>
                <a href="/SelectDishByIdServlet?id=${item.id}">评价</a>
                <a href="/SelectDishCommentByIdServlet?id=${item.id}">查看评价信息</a>
                <a href="/ComplaintFormServlet?id=${item.id}&canteen=${item.canteen}&dish=${item.id}">提交投诉</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
