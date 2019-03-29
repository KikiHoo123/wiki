<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  TimeUtils: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>私信列表</title>
</head>
<body>
<c:out value="${msg}"/>
<table align="center">
    <tr>
        <th colspan="7" align="left"><a href="${pageContext.request.contextPath}/mail/add">添加</a></th>
    </tr>
    <tr>
        <th>发送人</th>
        <th>接收人</th>
        <th>发送时间</th>
        <th>发送内容</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${mailList}" var="mail">
        <tr>
            <td>${mail.sender.name}</td>
            <td>${mail.receiver.name}</td>
            <td>${mail.time}</td>
            <td>${mail.content}</td>
            <td><a href="${pageContext.request.contextPath}/mail/get/${mail.id}">详情</a></td>
            <td><a href="${pageContext.request.contextPath}/mail/edit/${mail.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/mail/del/${mail.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
