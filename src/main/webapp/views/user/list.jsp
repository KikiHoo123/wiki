<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:44
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
    <caption>用户表</caption>
    <tr>
        <td>账号</td>
        <td>类型</td>
        <td>密码</td>
        <td>姓名</td>
        <td>性别</td>
        <td>头像</td>
        <td>学院</td>
        <td>个性签名</td>
        <td>tel</td>
        <td>邮箱</td>
        <td colspan="3">操作</td>
    </tr>
    <c:forEach items="${userList}" var="user" >
        <tr>
            <td>${user.num}</td>
            <td>${user.type}</td>
            <td>${user.password}</td>
            <td>${user.name}</td>
            <td>${user.sex}</td>
            <td>${user.photo}</td>
            <td>${user.academy}</td>
            <td>${user.signature}</td>
            <td>${user.tel}</td>
            <td>${user.mailbox}</td>
            <td><a href="${pageContext.request.contextPath}/user/get/${user.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/user/edit/${user.id}">编辑</a></td>
            <td><a href="${pageContext.request.contextPath}/user/del/${user.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
