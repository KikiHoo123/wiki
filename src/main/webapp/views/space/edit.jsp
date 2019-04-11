<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>空间编辑页面</title>
</head>
<body>
<%--@elvariable id="space" type="com.bsc.modules.space.entity.Space"--%>
<form:form modelAttribute="space" action="${pageContext.request.contextPath}/space/save/${space.id}">
    <table>
        <!--<tr>
            <td></td>
            <td><form:input path="time"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:input path="creator.id"/></td>
        </tr>
        <tr>
            <td></td>
            <td><form:input path="type"/></td>
        </tr>-->
        <tr>
            <td>空间名</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><form:input path="intro"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form:form>
</body>
</html>

