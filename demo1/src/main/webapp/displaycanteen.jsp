<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询食堂</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
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
        #add {
            margin-bottom: 10px;
        }
        hr {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
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
            <td>
                <a href="/demo1_war_exploded/SelectCanteenByNameServlet?name=${item.name}">修改</a>
                <a href="/demo1_war_exploded/DeleteCanteenByNameServlet?name=${item.name}">删除</a>
            </td>
        </tr>
    </c:forEach>
    <script>
        document.getElementById("add").onclick = function(){
            location.href="/demo1_war_exploded/addcanteen.jsp";
        }
    </script>
</table>
</body>
</html>
