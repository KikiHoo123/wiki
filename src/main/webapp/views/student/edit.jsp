<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="student" type="com.bsc.modules.student.entity.Student"--%>
<form:form modelAttribute="student" action="../save/${student.id}">
    <table border="1" align="center">
        <caption>修改</caption>
        <tr>
            <td>用户id</td>
            <td><form:input path="userID.id"/></td>
        </tr>
        <tr>
            <td>年级</td>
            <td><form:input path="grade"/></td>
        </tr>
        <tr>
            <td>专业</td>
            <td><form:input path="step"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/> </td>
            <td><input type="reset" value="重置"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
