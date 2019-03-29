<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>用户表</caption>
    <tr>
        <td>账号</td>
        <td>类型</td>
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>头像</td>
        <td>学院</td>
        <td>个性签名</td>
        <td>tel</td>
        <td>邮箱</td>
    </tr>
    <tr>
        <td>${user.num}</td>
        <td>${user.type}</td>
        <td>${user.password}</td>
        <td>${user.name}</td>
        <td>${user.sex}</td>
        <td>${user.photo}</td>
        <td>${user.academy}</td>
        <td>${user.signature}</td>
        <td>${user.tel}</td>
        <td>${user.mailbox}</td>
    </tr>
</table>
</body>
</html>
