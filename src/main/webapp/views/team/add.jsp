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
</head>
<body>
<%--@elvariable id="team" type="com.bsc.modules.team.entity.Team"--%>
<form:form modelAttribute="team" id="form1" action="${pageContext.request.contextPath}/team/save">
    <input hidden value="${sessionScope.user.id}" name="creator"/>
    <table align="center">
        <!--<tr>
            <td>creator</td>
            <td><form:input path="creator.id"/></td>
        </tr>
        <tr>
            <td>time</td>
            <td><form:input path="time"/></td>
        </tr>-->
        <tr>
            <td>团队名称</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>团队介绍</td>
            <td><form:input path="intro"/></td>
        </tr>
        <tr>
            <td>选择成员</td>
            <td><select name="tmember" multiple="multiple">
                <c:forEach var="user" items="${userList}">
                    <option value="${user.id}">${user.name}(${user.num})</option>
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="保存"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
