<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加菜品评价</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
            width: 300px; /* 设置表单宽度 */
        }
        .form-group {
            margin-bottom: 15px; /* 设置每组表单元素的下边距 */
        }
        .form-group label {
            display: block; /* 使标签独占一行 */
            margin-bottom: 5px; /* 设置标签和输入框之间的距离 */
        }
        input[type="text"] {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%; /* 输入框占满整行宽度 */
        }
        input[type="submit"] {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            width: 100%; /* 提交按钮占满整行宽度 */
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<form action="/demo1_war_exploded/AddDishCommentByIdServlet" method="post">
    <input type="hidden" name="canteen" value="${dish.canteen}">
    <input type="hidden" name="dish" value="${dish.id}">

    <div class="form-group">
        <label>食堂：</label>
        <input type="text" name="canteen1" value="${dish.canteen}">
    </div>

    <div class="form-group">
        <label>名字：</label>
        <input type="text" name="dish1" value="${dish.id}">
    </div>

    <div class="form-group">
        <label>评价信息：</label>
        <input type="text" name="cmessage">
    </div>

    <div class="form-group">
        <label>分数：</label>
        <input type="text" name="grade">
    </div>

    <input type="submit" value="提交">
</form>
</body>
</html>
