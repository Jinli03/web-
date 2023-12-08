<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Gender</th>
        <th>Age</th>
        <th>Address</th>
        <th>Hobby</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userlist}" var="user">
        <tr>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.address}</td>
            <td>${user.hobby}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
