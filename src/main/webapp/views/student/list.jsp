<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:10
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
    <caption>学生表</caption>
    <tr>
        <td>用户id</td>
        <td>年级</td>
        <td>授课</td>
        <td colspan="3">操作</td>
    </tr>
    <c:forEach items="${studentList}" var="student" >
        <tr>
            <td>${student.userID.id}</td>
            <td>${student.grade}</td>
            <td>${student.step}</td>
            <td><a href="${pageContext.request.contextPath}/student/get/${student.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/student/edit/${student.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/student/del/${student.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
