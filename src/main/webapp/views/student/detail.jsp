<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>学生表</caption>
    <tr>
        <td>用户id</td>
        <td>年级</td>
        <td>专业</td>
    </tr>
    <tr>
        <td>${student.userID.id}</td>
        <td>${student.grade}</td>
        <td>${student.step}</td>
    </tr>
</table>
</body>
</html>
