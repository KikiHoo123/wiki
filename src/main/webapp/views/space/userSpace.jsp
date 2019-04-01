<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/27
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table align="center">
    <caption>${space.name}的详情页</caption>
    <tr>
        <th>创始人id</th>
        <th>空间名</th>
        <th>类型</th>
        <th>创建时间</th>
        <th>描述</th>
    </tr>
    <tr>
        <td align = "center">${space.creator.name}</td>
        <td align = "center">${space.name}</td>
        <td align = "center">${space.type}</td>
        <td align = "center">${space.time}</td>
        <td align = "center">${space.intro}</td>
    </tr>
</table>
<table align="center">
    <c:forEach items="${wikiList}" var="wiki">
        <tr>
            <td><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></td>
            <td>${wiki.content}</td>
            <td>${wiki.lasttime}</td>
            <td><a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
