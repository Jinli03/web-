<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询食堂管理员</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        input[type="button"] {
            margin-bottom: 10px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }
        input[type="button"]:hover {
            background-color: #45a049;
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
    </style>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>用户名</th>
        <th>所属食堂</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cuser}" var="item" varStatus="status">
        <tr align="center">
            <td>${item.username}</td>
            <td>${item.canteen}</td>
            <td>
                <a href="/SelectCanteenManagerByUsernameServlet?username=${item.username}">修改</a>
                <a href="/DeleteCanteenManagerByUsernameServlet?username=${item.username}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    document.getElementById("add").onclick = function(){
        location.href="/addcanteenmanager.jsp";
    }
</script>
</body>
</html>
