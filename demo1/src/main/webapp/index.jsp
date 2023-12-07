<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
</head>
<body>
<form action="http://localhost:8080/demo1_war_exploded/LoginServlet" method="post">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="text" name="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
