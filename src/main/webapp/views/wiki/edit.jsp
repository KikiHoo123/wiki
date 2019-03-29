<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="wiki" type="com.bsc.modules.wiki.entity.Wiki"--%>
<form:form modelAttribute="wiki" action="${pageContext.request.contextPath}/wiki/save/${wiki.id}">
    <table align="center">
        <!--<tr>
            <td>所在空间</td>
            <td><form:input path="space.id"/></td>
        </tr>-->
        <!-- <tr>
            <td>创建人</td>
            <td><form:input path="creator.id"/></td>
        </tr>
        <tr>
            <td>创建时间</td>
            <td><form:input path="time"/></td>
        </tr><tr>
            <td>最后修改时间</td>
            <td><form:input path="lasttime"/></td>
        </tr><tr>
            <td>最后修改人</td>
            <td>
                <form:input path="modifier.id"/>
            </td>
        </tr>-->
        <tr>
            <td>wiki title</td>
            <td><form:input path="title"/></td>
        </tr>
        <tr>
            <td>wiki content</td>
            <td>
                <textarea id="editor" placeholder="这里输入内容" autofocus>
                    <form:input path="content"/>
                </textarea>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
