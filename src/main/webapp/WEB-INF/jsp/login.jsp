<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/23
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/user/dologin">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="password" ></p>
        <p><input type="submit" value="login"> </p>
    </form>
</body>
</html>
