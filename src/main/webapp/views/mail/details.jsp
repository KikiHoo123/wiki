<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mail详情页</title>
</head>
<body>
<table>
<tr>
    <th>发送人</th>
    <th>接收人</th>
    <th>发送时间</th>
    <th>发送内容</th>
</tr>
    <tr>
    <td>${mail.sender.name}</td>
    <td>${mail.receiver.name}</td>
    <td>${mail.time}</td>
    <td>${mail.content}</td>
    </tr>
</table>
</body>
</html>
