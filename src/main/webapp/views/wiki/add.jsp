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
    <title>新建wiki</title>
    <link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/animate.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/tools/simditor/styles/simditor.css" />
    <link href="${pageContext.request.contextPath}/tools/css/style.css" rel="stylesheet">
</head>
<body>
<!--空间id 创建者 时间什么的都没写-->
<%--@elvariable id="wiki" type="com.bsc.modules.wiki.entity.Wiki"--%>
<form:form modelAttribute="wiki" action="${pageContext.request.contextPath}/wiki/${space.id}/save">
    <table align="center">
        <!--<tr>
            <td>所在空间</td>
            <td><form:input path="space.id"/>
            </td>
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
            <td><div class="ibox-content"><h4>请输入标题:</h4></div></td>
        </tr>
        <tr>
            <td><div class="ibox-content"><form:input path="title"/></div></td>
        </tr>
        <tr>
            <td>
                <div class="ibox-content"><h4>请输入内容:</h4></div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="ibox-content">
                    <textarea id="editor" name="content" placeholder="这里输入内容" autofocus>
                        <form:input path="content"/>
                    </textarea>

                </div>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="保存"/></td>
        </tr>
    </table>
  <!--  <input hidden value="${space.id}" name="space"/>-->
</form:form>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/tools/js/content.js"></script>


<!-- simditor -->
<script type="text/javascript" src="${pageContext.request.contextPath}/tools/simditor/scripts/module.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/tools/simditor/scripts/uploader.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/tools/simditor/scripts/hotkeys.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/tools/simditor/scripts/simditor.js"></script>
<script>
    $(document).ready(function () {
        var editor = new Simditor({
            textarea: $('#editor'),
        });
    });
</script>
</body>
</html>
