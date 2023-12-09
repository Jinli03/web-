<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
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
        <td><a href="/demo1_war_exploded/SelectCanteenManagerByUsernameServlet?username=${item.username}">修改</a><a href="#">删除</a></td>
    </tr>
    </c:forEach>
    <script>
        document.getElementById("add").onclick = function(){
            location.href="/demo1_war_exploded/addcanteenmanager.jsp";
        }
    </script>
</body>
</html>
