<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新食堂信息</title>
</head>
<body>
<form action="/demo1_war_exploded/UpdateCanteenServlet" method="post">
    <input type="hidden" name="id" value="${canteen.name}">
    食堂名称：<input name="name" value="${canteen.name}"><br>
    运营时间：<input name="time" value="${canteen.time}"><br>
    位置：<input name="position" value="${canteen.position}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>