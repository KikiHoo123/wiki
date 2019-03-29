<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="user" type="com.bsc.modules.user.entity.User"--%>
<form:form modelAttribute="user" action="../save/${user.id}">
    <table border="1" align="center">
        <caption>修改</caption>
        <tr>
            <td>账号</td>
            <td><form:input path="num"/></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><form:input path="type"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td>姓名</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><form:input path="sex"/></td>
        </tr>
        <tr>
            <td>头像</td>
            <td><form:input path="photo"/></td>
        </tr>
        <tr>
            <td>学院</td>
            <td><form:input path="academy"/></td>
        </tr>
        <tr>
            <td>个性签名</td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><form:input path="tel"/></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td><form:input path="mailbox"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"/> </td>
            <td><input type="reset" value="重置"/> </td>
        </tr>
    </table>

</form:form>
</body>
</html>
