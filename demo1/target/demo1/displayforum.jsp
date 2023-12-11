<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛信息</title>
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
        <tr align="centre">
            <td>${item.id}</td>
            <td>${item.message}</td>
            <td>${item.pperson}</td>
            <td>${item.posttime}</td>
            <td>${item.likes}</td>
            <td>${item.rperson}</td>
            <td>${item.rmessage}</td>
            <td>${item.rposttime}</td>
            <td><a href="/demo1_war_exploded/SelectForumByIdServlet?id=${item.id}">修改</a>
                <a href="/demo1_war_exploded/DeleteForumByIdServlet?id=${item.id}">删除</a></td>
        </c:if>
        </tr>
    </c:forEach>
</table>

</c:forEach>
</body>
</html>
