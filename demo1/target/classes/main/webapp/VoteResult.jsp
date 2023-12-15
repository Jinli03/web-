<%--
  Created by IntelliJ IDEA.
  User: Popeyeeee
  Date: 2023/12/10
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>投票结果</title>
</head>
<body>
<h2>投票结果</h2>



   <table border="1">
    <tr>
        <th>评价 / 问题</th>
        <th>q1</th>
        <th>q2</th>
        <th>q3</th>
        <th>q4</th>
        <th>q5</th>
    </tr>


    <c:forEach var="entry" items="${voteCounts}">
        <tr>
            <td style="text-align: center; font-size: 16px;"><c:out value="${entry.key == '1' ? '很好' : entry.key == '2' ? '比较好' : entry.key == '3' ? '一般' : '较差'}"/></td>

            <c:forEach var="count" items="${entry.value}">
                <td style="text-align: center; font-size: 16px;"><c:out value="${count}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>

