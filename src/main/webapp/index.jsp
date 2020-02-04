<%@page pageEncoding="utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="user/logout">登出</a>
欢迎您:
<shiro:user>
    <shiro:principal/>
</shiro:user>
<shiro:notAuthenticated>
    <a href="/user/login">请登录</a>
</shiro:notAuthenticated>
<shiro:guest>
    游客~~~
</shiro:guest>
<hr>
<shiro:hasRole name="banzhang">
    <a href="0">到财务取钱</a>
</shiro:hasRole>
<shiro:lacksRole name="banzhang">
    <a href="">等财务发通知</a>
</shiro:lacksRole>
<hr>
<shiro:hasPermission name="student:query">
    <a href="">查询所有用户</a>
</shiro:hasPermission>
<shiro:lacksPermission name="student:query">
    <a href="">查询自己</a>
</shiro:lacksPermission>
</body>
</html>
