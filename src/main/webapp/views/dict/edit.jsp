<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="dict" type="com.bsc.modules.dict.entity.Dict"--%>
<form:form modelAttribute="dict" action="../save/${dict.id}">
    <table border="1" align="center">
        <caption>修改</caption>
        <tr>
            <td>键值</td>
            <td><form:input path="value"/></td>
        </tr>
        <tr>
            <td>标签</td>
            <td><form:input path="label"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><form:input path="description"/></td>
        </tr>
        <tr>
            <td>排序</td>
            <td><form:input path="sort"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/> </td>
            <td><input type="reset" value="重置"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
