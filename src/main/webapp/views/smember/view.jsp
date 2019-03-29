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
    <title>成员详情页</title>
</head>
<body>
<table align="center">
    <caption>${smember.type}的详情页</caption>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>所属空间</th>
        <th>类型</th>
    </tr>
    <tr>
        <td align = "center">${smember.id}</td>
        <td align = "center">${smember.member.name}</td>
        <td align = "center">${smember.spaceID.name}</td>
        <td align = "center">${space.type}</td>
    </tr>
</table>
</body>
</html>
