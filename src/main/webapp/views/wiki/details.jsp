<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${wiki.title}的详情页</title>
</head>
<body>

<table align="center">
    <tr>
        <th>父节点</th>
        <td>${wiki.wiki.title}</td>
    </tr>
    <tr>
        <th>所属空间</th>
        <td>${wiki.space.name}</td>
    </tr>
    <tr>
        <th>标题</th>
        <td>${wiki.title}</td>
    </tr>
    <tr>
        <th>创建人</th>
        <td>${wiki.creator.name}</td>
    </tr>
    <tr>
        <th>创建时间</th>
        <td>${wiki.time}</td>
    </tr>
    <tr>
        <th>内容</th>
        <td>${wiki.content}</td>
    </tr>
    <tr>
        <th>最近修改人</th>
        <td>${wiki.modifier.name}</td>
    </tr>
    <tr>
        <th>最近修改时间</th>
        <td>${wiki.lasttime}</td>
    </tr>
</table>
</body>
</html>
