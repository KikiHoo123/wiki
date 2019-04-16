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
    <link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/style.css" rel="stylesheet">
</head>
<body>
<div class="wrapper wrapper-content animated fadeInRight">
<div class="ibox float-e-margins">
    <div class="ibox-title">
        <h5>${team.title}</h5>
    </div>
    <div class="ibox-content">
        <p>团队介绍:</p>
        <p>${team.intro}</p>
        <p>团队成员:</p>
        <ul>
            <c:forEach items="${tmemberList}" var="tmember">
                <li><c:out value="${tmember.member.name} "/></li>
            </c:forEach>
        </ul>
    </div>
</div>
</div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
</body>
</html>
