<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/1
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <caption>字典表</caption>
    <tr>
        <td>键值</td>
        <td>标签</td>
        <td>类型</td>
        <td>描述</td>
        <td>排序</td>
    </tr>
    <tr>
        <td>${dict.value}</td>
        <td>${dict.label}</td>
        <td>${dict.type}</td>
        <td>${dict.description}</td>
        <td>${dict.sort}</td>
    </tr>
</table>
</body>
</html>
