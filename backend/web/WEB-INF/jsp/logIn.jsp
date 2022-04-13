<%--
  Created by IntelliJ IDEA.
  User: Xie Zhixuan
  Date: 2021/10/27
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<form action="/user/login"  method="get">
    <input type="text" name="username" value="enter user name:">
    <input type="text" name="password" value="enter user password:">
    <input type="submit" value="log In">
</form>
</body>
</html>
