<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <style>

        form {

            text-align: center;
            position: absolute;
            top: 30%;
            left: 0;
            right: 0;
            margin: 0 auto;
            border: 1px solid blue ;
            width: 223px;
            padding: 5px;
        }

        form input[type="text"],
        form textarea,
        form input[type="file"] {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            width: 100%;
            background-color: orange;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        form button:hover {
            background-color:royalblue;
        }
    </style>

    <STYLE type=text/css>
        TD {
            FONT-SIZE: 12px; COLOR: #000000
        }
        INPUT {
            FONT-SIZE: 12px; COLOR: #000000
        }
        SELECT {
            FONT-SIZE: 12px; COLOR: #000000
        }
        TD.nav {
            FILTER: DropShadow( Color#ffffff, OffX1, OffY1)
        }
        TD.nav A {
            COLOR: #000000; TEXT-DECORATION: none
        }
        TD.nav A:hover {
            COLOR: #000000
        }
        p1 {
            FONT-SIZE: 12px
        }
        p2 {
            FONT-SIZE: 12px; LINE-HEIGHT: 130%
        }
        p3 {
            FONT-SIZE: 14px
        }
        p4 {
            FONT-SIZE: 14px; LINE-HEIGHT: 130%
        }
        p5 {
            FONT-SIZE: 12px; LINE-HEIGHT: 180%
        }
        p6 {
            LINE-HEIGHT: 240%
        }
        p7 {
            COLOR: #404642; LINE-HEIGHT: 150%
        }
        .text {
            COLOR: #3c3c3c; LINE-HEIGHT: 180%
        }
        .text1 {
            FONT-SIZE: 14px; COLOR: #3c3c3c; LINE-HEIGHT: 180%
        }
        A:link {
            COLOR: #000000
        }
        A:visited {
            COLOR: #000000
        }
        A:hover {
            COLOR: #000000
        }
        .STYLE2 {color: #316AC5}
    </STYLE>

</head>
<BODY leftMargin=0 background=backg.gif topMargin=0
      marginheight="0" marginwidth="0">



<form action="http://localhost:8080/demo1_war_exploded/LoginServlet" method="post">
    用户名：<input type="text" name="username"> <br>
    密码：<input type="text" name="password"> <br>
    <input type="submit" value="登录">


</form>

</body>
</html>
