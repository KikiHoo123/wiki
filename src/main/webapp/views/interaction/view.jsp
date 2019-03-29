<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>互动详情页</title>
</head>
<body>
<table align="center">
    <caption>${interaction.type}的详情页</caption>
    <tr>
        <th>id</th>
        <th>wikiID</th>
        <th>用户ID</th>
        <th>空间ID</th>
        <th>时间</th>
        <th>类型</th>
        <th>评论内容</th>
    </tr>
    <tr>
        <td align = "center">${interaction.id}</td>
        <td align = "center">${interaction.wikiID.title}</td>
        <td align = "center">${interaction.userID.name}</td>
        <td align = "center">${interaction.spaceID.name}</td>
        <td align = "center">${interaction.time}</td>
        <td align = "center">${interaction.type}</td>
        <td align = "center">${interaction.content}</td>
    </tr>
</table>
</body>
</html>
