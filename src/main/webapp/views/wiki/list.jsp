<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.github.pagehelper.PageHelper"%>
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
</head>
<body >
<c:out value="${msg}"/>
<table align="center">
    <!--<tr>
        <th colspan="7" align="left"><a href="${pageContext.request.contextPath}/wiki/add">添加</a></th>
    </tr>-->
    <tr>
        <!--<th>父节点</th>-->
        <!--<th>所属空间</th>-->
        <th>标题</th>
        <th>创建人</th>
        <!--<th>创建时间</th>-->
        <th>内容</th>
        <!--<th>最近修改人</th>-->
        <th>最近修改时间</th>

        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${wikiList}" var="wiki">
        <tr>
            <td><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></td>
            <!--<td>${wiki.space.name}</td>
            <td>${wiki.title}</td>-->
            <td>${wiki.creator.name}</td>
            <!--<td>${wiki.time}</td>-->
            <td>${wiki.content}</td>
            <!--${wiki.modifier.name}</td>--><td>
            <td>${wiki.lasttime}</td>
            <td><a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

