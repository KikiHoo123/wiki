<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="teacher" type="com.bsc.modules.teacher.entity.Teacher"--%>
<form:form modelAttribute="teacher" action="../save/${teacher.id}">
    <table border="1" align="center">
        <caption>修改</caption>
        <tr>
            <td>用户id</td>
            <td><form:input path="userID.id"/></td>
        </tr>
        <tr>
            <td>授课</td>
            <td><form:input path="lecture"/></td>
        </tr>
        <tr>
            <td>简介</td>
            <td><form:input path="intro"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/> </td>
            <td><input type="reset" value="重置"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
