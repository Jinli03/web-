<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>系统管理员</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@2"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <script src="https://unpkg.com/vue-router/dist/vue-router.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">

</head>
<body>
欢迎你${username}系统管理员
<a href="/demo1_war_exploded/QueryCanteenManagerServlet">查询食堂管理员</a>
<a href="/demo1_war_exploded/QueryCanteenServlet">查询食堂</a>
<a href="/demo1_war_exploded/QueryCommentServlet">查询评价信息</a>
</body>
</html>
