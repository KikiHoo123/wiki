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
    <!--<link rel="stylesheet" type="text/css" href="../../tools/css/font-awesome.css" />
    <link rel="stylesheet" type="text/css" href="../../tools/simditor/styles/simditor.css" />
    <script type="text/javascript" src="../../tools/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../tools/simditor/scripts/module.js">
    </script>
    <script type="text/javascript" src="../../tools/simditor/scripts/uploader.js">
</script>
    <script type="text/javascript" src="../../tools/simditor/scripts/simditor.js"></script>
    <script>
        var editor = new Simditor({   textarea: $('#editor') });
    </script>-->
    <script type="text/javascript" src="../../tools/Ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../../tools/Ueditor/ueditor.all.js"></script>
    <script type="text/javascript" src="../../tools/Ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="../../tools/js/jquery.min.js"></script>
   <script type="text/javascript">
        var editor = UE.getEditor('container');
    </script>

    <!--<script type="text/javascript" charset="utf-8">

        var editor = new baidu.editor.ui.Editor();

        editor.render("contents");

    </script>-->
</head>
<body>
<!-空间id 创建者 时间什么的都没写->
<%--@elvariable id="wiki" type="com.bsc.modules.wiki.entity.Wiki"--%>
<form:form modelAttribute="wiki" action="${pageContext.request.contextPath}/wiki/save">
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
                <textarea id="container" name="content" placeholder="这里输入内容">
                    ${wiki.content}
                </textarea>
                <!--<textarea id="editor"  autofocus>

                </textarea>-->
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="submit"/> </td>
        </tr>
    </table>
</form:form>
</body>
</html>
