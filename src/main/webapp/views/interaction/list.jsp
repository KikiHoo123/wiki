<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>interaction</title>
</head>
<body>
<c:out value="${msg}"/>
<table border="1">
    <caption>互动表</caption>
    <tr>
        <th>id</th>
        <th>wiki</th>
        <th>用户</th>
        <th>空间</th>
        <th>时间</th>
        <th>类型</th>
        <th>评论内容</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${interactionList}" var="interaction" >
        <tr>
            <td align = "center">${interaction.id}</td>
            <td align = "center">${interaction.wikiID.title}</td>
            <td align = "center">${interaction.userID.name}</td>
            <td align = "center">${interaction.spaceID.name}</td>
            <td align = "center">${interaction.time}</td>
            <td align = "center">${interaction.type}</td>
            <td align = "center">${interaction.content}</td>
            <td align="center" ><a href="${pageContext.request.contextPath}/interaction/get/${interaction.id}"><input type="button" value="详情"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/interaction/edit/${interaction.id}"><input type="button" value="编辑"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/interaction/del/${interaction.id}"><input type="button" value="删除"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" ><a href="${pageContext.request.contextPath}/interaction/add"><input type="button" value="添加"></a></td>
    </tr>
</table>
</body>
</html>
