<%--
  Created by IntelliJ IDEA.
  User: Popeyeeee
  Date: 2023/12/12
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>搜索页面</title>
    <script>
        function submitForm() {
            document.getElementById("searchForm").submit();
        }

        // 在页面加载时检查是否有搜索结果，决定是否显示结果区域
        window.onload = function() {
            var dishEmpty = ${empty dish};
            var resultDiv = document.getElementById("searchResult");

            if (dishEmpty) {
                // 如果无搜索结果，隐藏结果区域
                checkSearchResults();
            } else {
                // 如果有搜索结果，显示结果区域
                resultDiv.style.display = "block";
            }
        };
    </script>

    <script>
        function checkSearchResults() {
            var dishEmpty = ${empty dish};
            if (dishEmpty) {
                alert("无搜索结果");
            }
        }
    </script>
</head>
<body>
<div style="text-align: center; margin-top: 50px;">
  <h2>搜索栏</h2>
  <form action="http://localhost:8080/demo1_war_exploded/SelectSingleDishServlet" method="post">
    <input type="text" id="searchTerm" name="search" placeholder="输入关键词">
    <button onclick="submitForm()">搜索</button>
  </form>

</div>


<div style="margin-top: 20px; text-align: center;">
    <c:choose>
        <c:when test="${not empty dish}">
            <p><img src="${dish.picture}" alt="Image Description" style="width: 300px; height: 200px;"></p>
            <p>菜名：${dish.id}</p>
            <p>菜系：${dish.kind}</p>
            <p>价格：￥${dish.price}</p>
            <p>评分：${dish.grade}</p>
            <p>供应食堂：${dish.canteen}</p>
        </c:when>
    </c:choose>

</div>


</body>
</html>

