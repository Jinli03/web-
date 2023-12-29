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
        <th>comment</th>
        <th>q1</th>
        <th>q2</th>
        <th>q3</th>
        <th>q4</th>
        <th>q5</th>
    </tr>
    <c:forEach items="${voteCounts}" var="item" varStatus="status">
        <tr align="center">
            <td>${item.comment}</td>
            <td>${item.q1}</td>
            <td>${item.q2}</td>
            <td>${item.q3}</td>
            <td>${item.q4}</td>
            <td>${item.q5}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
