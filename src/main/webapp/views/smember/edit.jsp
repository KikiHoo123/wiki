<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成员编辑页面</title>
</head>
<body>
<%--@elvariable id="space" type="com.bsc.modules.space.entity.Space"--%>
<form:form modelAttribute="smember" action="${pageContext.request.contextPath}/smember/save/${smember.id}">
    <table>
        <tr>
            <td>空间</td>
            <td><form:input path="spaceID.id"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>用户</td>
            <td><form:input path="member.id"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form:form>
</body>
</html>

