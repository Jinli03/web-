<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        hr {
            border: 0;
            height: 1px;
            background-color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
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
<hr>
<table>
    <tr>
        <th>食堂名称</th>
        <th>运营时间</th>
        <th>位置</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${canteen}" var="item" varStatus="status">
        <tr align="center">
            <td>${item.name}</td>
            <td>${item.time}</td>
            <td>${item.position}</td>
            <td><a href="/SelectDishesByCanteenNameServlet?name=${item.name}">查看食堂菜品</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
