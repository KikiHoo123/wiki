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
<link href="${pageContext.request.contextPath}/tools/css/plugins/footable/footable.core.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/style.css" />
<html>
<head>
    <title>space</title>
</head>
<body>
<c:out value="${msg}"/>
<div class="ibox-content">
<table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
    <thead>
    <tr>
        <td><a href="${pageContext.request.contextPath}/space/add"><input type="button" value="创建空间"></a></td>
    </tr>
    <tr>
        <th>空间名</th>
        <th>描述</th>
        <th>创建时间</th>
        <th colspan="2">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${spaceList}" var="space" >
    <tr>
        <td><a href="${pageContext.request.contextPath}/team/detail/${space.id}" target="_parent">${space.name}</a></td>
        <td>${space.intro}</td>
        <td>${space.time}</td>
        <td><a href="${pageContext.request.contextPath}/space/edit/${space.id}"><input type="button" value="编辑"></a></td>
        <td><a href="${pageContext.request.contextPath}/space/del/${space.id}"><input type="button" value="删除"></a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
