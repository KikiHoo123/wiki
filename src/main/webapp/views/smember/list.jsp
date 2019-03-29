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
    <title>space</title>
</head>
<body>
<c:out value="${msg}"/>
<table border="1">
    <caption>成员信息</caption>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>所属空间</th>
        <th>类型</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${smemberList}" var="smember" >
        <tr>
            <td align = "center">${smember.id}</td>
            <td align = "center">${smember.member.name}</td>
            <td align = "center">${smember.spaceID.name}</td>
            <td align = "center">${smember.type}</td>

            <td align="center" ><a href="${pageContext.request.contextPath}/smember/get/${smember.id}"><input type="button" value="详情"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/smember/edit/${smember.id}"><input type="button" value="编辑"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/smember/del/${smember.id}"><input type="button" value="删除"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" ><a href="${pageContext.request.contextPath}/space/add"><input type="button" value="添加"></a></td>
    </tr>
</table>
</body>
</html>
