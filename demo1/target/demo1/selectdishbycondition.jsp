<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>检索菜品</title>
</head>
<body>
<form action="http://localhost:8080/demo1_war_exploded/SelectAllDishesByConditionsServlet" method="post">
    菜品：<input type="text" name="kind"> <br>
    价格（小于）<input type="text" name="price"> <br>
    食堂<input type="text" name="canteen"> <br>
    <input type="submit" value="检索">
</form>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>菜名</th>
        <th>菜品</th>
        <th>食堂</th>
        <th>价格</th>
        <th>评分</th>
        <th>图片</th>
    </tr>
    <c:forEach items="${dishes}" var="item" varStatus="status">
        <tr align="centre">
            <td>${item.id}</td>
            <td>${item.kind}</td>
            <td>${item.canteen}</td>
            <td>${item.price}</td>
            <td>${item.grade}</td>
            <td>${item.picture}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
