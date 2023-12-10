<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询评价信息</title>
</head>
<body>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>评价序号</th>
        <th>食堂</th>
        <th>菜品</th>
        <th>时间</th>
        <th>评价人</th>
        <th>评价内容</th>
        <th>分数</th>
        <th>回复人</th>
        <th>回复内容</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${comment}" var="item" varStatus="status">
    <tr align="centre">
        <td>${item.id}</td>
        <td>${item.canteen}</td>
        <td>${item.dish}</td>
        <td>${item.time}</td>
        <td>${item.cperson}</td>
        <td>${item.cmessage}</td>
        <td>${item.grade}</td>
        <td>${item.rperson}</td>
        <td>${item.rmessage}</td>
        <td><a href="/demo1_war_exploded/SelectCommentByIdServlet?id=${item.id}">修改</a>
            <a href="/demo1_war_exploded/DeleteCommentByIdServlet?id=${item.id}">删除</a></td>
    </tr>
    </c:forEach>

</body>
</html>
