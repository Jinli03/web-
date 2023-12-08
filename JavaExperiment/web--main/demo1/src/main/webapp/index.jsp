<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<form action="http://localhost:8080/demo1_war_exploded/Display" method="post">
    <div class="na">
        <p>用户名：</p>
        <input type="text" name="name" placeholder="请输入用户名">
    </div>
    <div class="ag">
        <p>密码：</p>
        <input type="text" name="password" placeholder="请输入密码">
    </div>

    <input type="submit" id="but" value="登录">
</form>
</body>
</html>
