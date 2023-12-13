<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>菜品</th>
        <th>时间</th>
        <th>评价人</th>
        <th>评价内容</th>
        <th>分数</th>
    </tr>
    <c:forEach items="${comment}" var="item" varStatus="status">
        <tr align="centre">
            <td>${item.dish}</td>
            <td>${item.time}</td>
            <td>${item.cperson}</td>
            <td>${item.cmessage}</td>
            <td>${item.grade}</td>
        </tr>
    </c:forEach>
    <form action="/demo1_war_exploded/SelectAllDishesByServlet" method="post">
        <input type="submit" value="返回">
    </form>
</table>
</body>
</html>
