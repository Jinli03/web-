<%--
  Created by IntelliJ IDEA.
  User: Popeyeeee
  Date: 2023/12/12
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>所有菜品</title>
</head>
<body>

<h2>所有菜品列表：</h2>

<c:forEach var="dish" items="${AllDishes}">
    <p><img src="${dish.picture}" alt="Image Description" style="width: 300px; height: 200px;">
    <p>菜名：${dish.id}</p>
    <p>菜系：${dish.kind}</p>
    <p>价格：￥${dish.price}</p>
    <p>评分：${dish.grade}</p>
    <p>供应食堂：${dish.canteen}</p>

    <hr>
</c:forEach>

</body>
</html>


