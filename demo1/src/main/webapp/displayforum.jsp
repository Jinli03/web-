<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛信息</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        h3 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 800px;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        hr {
            margin-top: 20px;
        }
        a {
            text-decoration: none;
            padding: 5px;
            margin: 2px;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f8f8f8;
            color: #333;
        }
        a:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
<c:forEach var="title" items="${titles}">
    <h3>${title}</h3>
    <table border="1" cellspacing="0" width="800">
        <tr>
            <th>论坛序号</th>
            <th>信息</th>
            <th>发布人</th>
            <th>发布时间</th>
            <th>点赞数</th>
            <th>回复人</th>
            <th>回复信息</th>
            <th>回复时间</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${forum}" var="item" varStatus="status">
            <c:if test="${item.title eq title}">
                <tr align="center">
                    <td>${item.id}</td>
                    <td>${item.message}</td>
                    <td>${item.pperson}</td>
                    <td>${item.posttime}</td>
                    <td>${item.likes}</td>
                    <td>${item.rperson}</td>
                    <td>${item.rmessage}</td>
                    <td>${item.rposttime}</td>
                    <td>
                        <a href="/SelectForumByIdServlet?id=${item.id}">修改</a>
                        <a href="/DeleteForumByIdServlet?id=${item.id}">删除</a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</c:forEach>
</body>
</html>
