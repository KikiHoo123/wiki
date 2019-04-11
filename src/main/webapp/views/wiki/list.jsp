<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 15:21
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>wiki列表</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/style.css" />
</head>
<body >
<c:out value="${msg}"/>
<table align="center">
    <c:forEach items="${wikiList}" var="wiki">
    <div class="search-result">
        <h3><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></h3>
        <a href="search_results.html#" class="search-link">‎${wiki.space.name}</a>
        <p>${wiki.content}
        </p>
        <a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a>
        <a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a>
    </div>
        <div class="hr-line-dashed"></div>
    </c:forEach>
</table>
</body>
</html>

