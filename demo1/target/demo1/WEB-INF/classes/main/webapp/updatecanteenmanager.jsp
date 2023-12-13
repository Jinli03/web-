<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新食堂管理员信息</title>
</head>
<body>
<form action="/demo1_war_exploded/UpdateCanteenManagerServlet" method="post">
    <input type="hidden" name="id" value="${cuser.username}">
    用户名：<input name="username" value="${cuser.username}"><br>
    密码：<input name="password" value="${cuser.password}"><br>
    所属食堂：<input name="canteen" value="${cuser.canteen}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
