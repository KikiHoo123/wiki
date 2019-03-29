<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:58
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
    <caption>教师表</caption>
    <tr>
        <td>用户id</td>
        <td>授课</td>
        <td>简介</td>
        <td colspan="3">操作</td>
    </tr>
    <c:forEach items="${teacherList}" var="teacher" >
        <tr>
            <td>${teacher.userID.id}</td>
            <td>${teacher.lecture}</td>
            <td>${teacher.intro}</td>
            <td><a href="${pageContext.request.contextPath}/teacher/get/${teacher.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/teacher/edit/${teacher.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/teacher/del/${teacher.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
