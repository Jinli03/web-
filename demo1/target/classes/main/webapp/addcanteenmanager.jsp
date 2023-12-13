<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加食堂管理员</title>
</head>
<body>
<h3>添加食堂管理员</h3>
<form action="/demo1_war_exploded/AddCanteenManagerServlet" method="post">
    用户名：<input name="username"><br>
    密码：<input name="password"><br>
    所属食堂：<input name="canteen"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
