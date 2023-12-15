<%--
  Created by IntelliJ IDEA.
  User: ccbus
  Date: 2023/12/14
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实时消息系统 - 学校食堂点评系统</title>
  <style>
      /* ... 其他样式 ... */

      #user-list, #message-area {
          border: 1px solid #ddd;
          margin: 10px;
          padding: 10px;
          border-radius: 4px;
      }

      #messages {
          height: 300px;
          overflow-y: auto;
          border: 1px solid #ccc;
          margin-bottom: 10px;
          padding: 5px;
      }

      #message-input {
          width: calc(100% - 20px);
          margin-bottom: 10px;
      }


  </style>
    <!-- 引入必要的JavaScript库，例如WebSocket或其他用于实时通讯的库 -->
</head>
<body>
<header>
    <!-- 导航栏内容 -->
</header>

<main>
    <div id="user-list">
        <h2>在线用户</h2>
        <ul>
            <!-- 动态生成在线用户列表 -->
            <li><a href="#" onclick="startChat('user1')">用户1</a></li>
            <li><a href="#" onclick="startChat('user2')">用户2</a></li>
            <!-- 更多用户 -->
        </ul>
    </div>

    <div id="message-area">
        <h2>消息</h2>
        <div id="messages"></div>
        <textarea id="message-input"></textarea>
        <button onclick="sendMessage()">发送</button>
    </div>
</main>

<footer>
    <!-- 页脚内容 -->
</footer>

<script type="text/javascript">
    var socket = new WebSocket("ws://yourserver.com/path");

    socket.onopen = function(e) {
        console.log("连接服务器成功");
    };

    socket.onmessage = function(event) {
        var incomingMessage = event.data;
        showMessage(incomingMessage);
    };

    function sendMessage() {
        var message = document.getElementById("message-input").value;
        socket.send(message);
    }

    function showMessage(message) {
        var messageDiv = document.createElement("div");
        messageDiv.textContent = message;
        document.getElementById("messages").appendChild(messageDiv);
    }

    function startChat(userName) {
        // 实现启动和特定用户聊天的逻辑
    }

</script>
</body>
</html>
