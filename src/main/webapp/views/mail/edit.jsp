<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  TimeUtils: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑私信</title>
</head>
<body>
<%--@elvariable id="mail" type="com.bsc.modules.mail.entity.Mail"--%>
<form:form modelAttribute="mail" action="${pageContext.request.contextPath}/mail/save/${mail.id}">
    <table align="center">
        <tr>
            <td>mail content</td>
            <td><form:input path="content"/></td>
        </tr>
        <tr>
            <td>发送人</td>
            <td><form:input path="sender.id"/></td>
        </tr>
        <tr>
            <td>接收人</td>
            <td><form:input path="receiver.id"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
