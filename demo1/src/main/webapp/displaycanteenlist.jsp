<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂信息</title>
</head>
<body>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>食堂名称</th>
        <th>运营时间</th>
        <th>位置</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${canteen}" var="item" varStatus="status">
    <tr align="centre">
        <td>${item.name}</td>
        <td>${item.time}</td>
        <td>${item.position}</td>
        <td><a href="/demo1_war_exploded/SelectDishesByCanteenNameServlet?name=${item.name}">查看食堂菜品</a>
    </tr>
    </c:forEach>
</body>
</html>
