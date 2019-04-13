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
    <title>${team.title}的详情页</title>
</head>
<body>
<table>
    <tr>
        <th colspan="2">${team.title}</th>
    </tr>
    <tr>
        <td>创建人</td>
        <td>${team.creator.name}</td>
    </tr>
    <tr>
        <td>创建时间</td>
        <td>${team.time}</td>
    </tr>
    <tr>
        <td>团队描述</td>
        <td>${team.intro}</td>
    </tr>
    <tr>
        <td>团队成员</td>
        <td>
            <c:forEach items="${tmemberList}" var="tmember">
                <c:out value="${tmember.member.name} "/>
            </c:forEach>
    </tr>
</table>
</body>
</html>
