<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>综合信息系统首页</title>
    <link rel="stylesheet" href="styles.css">
    <style>
        .announcement-box {
            border: 1px solid #000; /* 设置边框 */
            margin-bottom: 20px; /* 每个公告之间的间隔 */
            padding: 10px; /* 内部间距 */
        }
        .announcement-header {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px; /* 标题和内容之间的间隔 */
        }
        .announcement-title {
            font-weight: bold; /* 标题加粗 */
        }
        .announcement-time {
            font-style: italic; /* 时间斜体显示 */
        }
        .announcement-content {
            /* 可以添加内容区域的特定样式 */
        }

    </style>
</head>
<body>
<header>
    <div id="cafeteria-info">
        <c:choose>
            <c:when test="${not empty cafeteria}">
                <p>食堂简介: ${cafeteria.description}</p>
                <p>营业时间: ${cafeteria.hours}</p>
            </c:when>
            <c:otherwise>
                <p>信息未设置</p>
            </c:otherwise>
        </c:choose>
    </div>
    <h1>食堂管理系统</h1>
    <div id="notifications">
        <p>未读投诉信息: ${count}</p>
    </div>
</header>
<nav>
    <ul>
        <li><a href="cafeteria-info-form.html#info">食堂信息维护</a></li>
        <li><a href="dishes.html">菜品维护</a></li>
        <li><a href="#reviews">食堂评价处理</a></li>
        <li><a href="ads.html#announce">活动公告</a></li>
        <li><a href="http://localhost:8080/demo1_war_exploded/DisplayVoteServlet">投票查询</a></li>
        <li><a href="http://localhost:8080/demo1_war_exploded/RecomplaintServlet">投诉信息处理</a></li>
        <li><a href="#recommendations">最新推荐菜品</a></li>
    </ul>
</nav>
<section id="info">
    <c:if test="${announce != null}">
        <c:forEach var="announceItem" items="${announce}">
            <div class="announcement-box">
                <div class="announcement-header">
                    <span class="announcement-title">${announceItem.title}</span>
                    <span class="announcement-time">${announceItem.time}</span>
                </div>
                <div class="announcement-content">
                        ${announceItem.content}
                </div>
            </div>
        </c:forEach>
    </c:if>
    </table>


</section>


<footer>
    <p>&copy; 2023 食堂管理系统</p>
</footer>
</body>
</html>

