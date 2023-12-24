<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px; /* 留出空间给表单 */
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
        .form-button {
            display: flex;
            justify-content: center;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #5cb85c;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #449d44;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>菜品</th>
        <th>时间</th>
        <th>评价人</th>
        <th>评价内容</th>
        <th>分数</th>
    </tr>
    <c:forEach items="${comment}" var="item" varStatus="status">
        <tr align="center">
            <td>${item.dish}</td>
            <td>${item.time}</td>
            <td>${item.cperson}</td>
            <td>${item.cmessage}</td>
            <td>${item.grade}</td>
        </tr>
    </c:forEach>
</table>
<div class="form-button">
    <form action="/demo1_war_exploded/SelectAllDishesByServlet" method="post">
        <input type="submit" value="返回">
    </form>
</div>
</body>
</html>
