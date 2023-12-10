<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加食堂</title>
</head>
<body>
<h3>添加食堂</h3>
<form action="/demo1_war_exploded/AddCanteenServlet" method="post">
    食堂名称：<input name="name"><br>
    运营时间：<input name="time"><br>
    位置：<input name="position"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
