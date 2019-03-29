<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${msg}"/>
<table align="center" border="1">
    <caption>字典表</caption>
    <tr>
        <td>键值</td>
        <td>标签</td>
        <td>类型</td>
        <td>描述</td>
        <td>排序</td>
        <td colspan="3">操作</td>
    </tr>
    <c:forEach items="${dictList}" var="dict" >
        <tr>
            <td>${dict.value}</td>
            <td>${dict.label}</td>
            <td>${dict.type}</td>
            <td>${dict.description}</td>
            <td>${dict.sort}</td>
            <td><a href="${pageContext.request.contextPath}/dict/get/${dict.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/dict/edit/${dict.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/dict/del/${dict.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
