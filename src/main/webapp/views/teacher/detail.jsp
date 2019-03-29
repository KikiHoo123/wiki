<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>教师表</caption>
    <tr>
        <td>用户id</td>
        <td>授课</td>
        <td>简介</td>
    </tr>
    <tr>
        <td>${teacher.userID.id}</td>
        <td>${teacher.lecture}</td>
        <td>${teacher.intro}</td>
    </tr>
</table>
</body>
</html>
