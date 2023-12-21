<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加菜品评价</title>
</head>
<body>
<form action="/demo1_war_exploded/AddDishCommentByIdServlet" method="post">
    <input type="hidden" name="canteen" value="${dish.canteen}">
    <input type="hidden" name="dish" value="${dish.id}">
    食堂<input type="text" name="canteen1" value="${dish.canteen}">
    名字<input type="text" name="dish1" value="${dish.id}">
    评价信息：<input type="text" name="cmessage"><br>
    分数：<input type="text" name="grade"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
