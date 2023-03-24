<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8"  %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
     <meta charset="utf-8">
    <title>Login</title>
    <link rel="stylesheet" href="<%= basePath+"loginWindow/css/master.css" %>" />
</head>
<body>
<div class="login-box">
    <img src="<%= basePath +"loginWindow/img/logo.png"%>" class="avatar" alt="Avatar Image">
    <h1>登录</h1>
    <form  action="login"  method="post"  >
        <!-- USERNAME INPUT -->
        <label for="username">用户名</label>
        <input type="text" placeholder="输入用户名" id="username" name="userName">
        <!-- PASSWORD INPUT -->
        <label for="password">密码</label>
        <input type="password" placeholder="输入密码" id="password" name="passWord">
        <input type="submit" value="登录">

        <a href="#">忘记密码</a><br>
        <a href="#">注册</a>

    </form>
</div>
</body>
</html>
