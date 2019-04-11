<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="team" type="com.bsc.modules.team.entity.Team"--%>
<form:form modelAttribute="team" action="${pageContext.request.contextPath}/team/save/${team.id}">
    <table align="center">
        <tr>
            <td>creator</td>
            <td><form:input path="creator.id"/></td>
        </tr>
        <tr>
            <td>team name</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>team introduction</td>
            <td><form:input path="intro"/></td>
        </tr>
        <tr>
            <td>time</td>
            <td><form:input path="time"/></td>
        </tr>
        <tr>
            <td>团队成员</td>
            <td>
                <c:forEach items="${tmemberList}" var="tmember">
                    <c:out value="${tmember.member.name} "/>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td><a href="${pageContext.request.contextPath}/tmember/edit">添加成员</a></td>
        </tr>
        <tr>
            <td><input type="submit" value="保存"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
