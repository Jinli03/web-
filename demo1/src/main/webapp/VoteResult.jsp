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
    <style>
        body {
            background-image: url('3.jpg'); /* 替换为你的背景图片路径 */
            background-size: cover;
            background-position: center;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column; /* 将子元素按列方向排列 */
            align-items: center;
            height: 100vh;
        }

        h2 {
            text-align: center;
            background-color: rgba(255, 255, 255, 0.8);
            padding: 10px;
            border-radius: 8px;
            margin-bottom: 1px; /* 调整标题与表格的间距 */
        }

        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
            background-color: rgba(255, 255, 255, 0.8);
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
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
            <td style="font-size: 16px;">
                <c:out value="${entry.key == '1' ? '很好' : entry.key == '2' ? '比较好' : entry.key == '3' ? '一般' : '较差'}"/>
            </td>

            <c:forEach var="count" items="${entry.value}">
                <td style="font-size: 16px;"><c:out value="${count}"/></td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>
</body>
</html>



