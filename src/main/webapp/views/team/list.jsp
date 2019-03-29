<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>团队列表</title>
</head>
<body>
<c:out value="${msg}"/>
<table align="center">
    <tr>
        <th colspan="7" align="left"><a href="${pageContext.request.contextPath}/team/add">添加</a></th>
    </tr>
    <tr>
        <th>团队名称</th>
        <th>创建人</th>
        <th>创建时间</th>
        <th>团队描述</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${teamList}" var="team">
        <tr>
            <td>${team.title}</td>
            <td>${team.creator.name}</td>
            <td>${team.time}</td>
            <td>${team.intro}</td>
            <td><a href="${pageContext.request.contextPath}/team/get/${team.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/team/edit/${team.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/team/del/${team.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
