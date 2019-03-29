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
    <title>空间详情页</title>
</head>
<body>
<table align="center">
    <caption>${space.name}的详情页</caption>
    <tr>
        <th>id</th>
        <th>创始人id</th>
        <th>空间名</th>
        <th>类型</th>
        <th>创建时间</th>
        <th>描述</th>
        <th>空间成员</th>
    </tr>
    <tr>
        <td align = "center">${space.id}</td>
        <td align = "center">${space.creator.name}</td>
        <td align = "center">${space.name}</td>
        <td align = "center">${space.type}</td>
        <td align = "center">${space.time}</td>
        <td align = "center">${space.intro}</td>
        <c:forEach items="${space.smemberList}" var="smember" >
            <td align = "center">${smember.member.name}<br></td>
        </c:forEach>
    </tr>
</table>
<table align="center">
    <c:forEach items="${wikiList}" var="wiki">
        <tr>
            <td><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></td>
            <td>${wiki.creator.name}</td>
            <td>${wiki.content}</td>
            <!--${wiki.modifier.name}</td>-->
            <td>${wiki.lasttime}</td>
            <td><a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
