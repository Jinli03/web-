<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>用户名</th>
        <th>所属食堂</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cuser}" var="item" varStatus="status">
    <tr align="centre">
        <td>${item.username}</td>
        <td>${item.canteen}</td>
        <td><a href="#">修改</a><a href="#">删除</a></td>
    </tr>
    </c:forEach>
</body>
</html>