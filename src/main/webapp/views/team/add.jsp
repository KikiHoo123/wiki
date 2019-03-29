<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>创建新团队</title>
</head>
<body>
<%--@elvariable id="team" type="com.bsc.modules.team.entity.Team"--%>
<form:form modelAttribute="team" id="form1" action="${pageContext.request.contextPath}/team/save">
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
            <select name="tmember" multiple="multiple">
                <c:forEach var="user" items="${userList}">
                    <option value="${user.id}">${user.name}(${user.num})</option>
                </c:forEach>
            </select>
        </tr>
    </table>
    <input type="submit" value="提交">
</form:form>
</body>
</html>
