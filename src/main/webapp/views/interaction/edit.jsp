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
    <title>互动编辑页面</title>
</head>
<body>
<%--@elvariable id="interaction" type="com.bsc.modules.interaction.entity.Interaction"--%>
<form:form modelAttribute="interaction" action="${pageContext.request.contextPath}/interaction/save/${interaction.id}">
    <table>
        <tr>
            <td>wikiID</td>
            <td><form:input path="wikiID.id"/></td>
        </tr>
        <tr>
            <td>用户ID</td>
            <td><form:input path="userID.id"/></td>
        </tr>
        <tr>
            <td>空间ID</td>
            <td><form:input path="spaceID.id"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>评论内容</td>
            <td><form:input path="content"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
