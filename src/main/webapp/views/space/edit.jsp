<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/font-awesome.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/style.css" rel="stylesheet">
</head>
<body>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/tools/js/content.js"></script>
<%--@elvariable id="space" type="com.bsc.modules.space.entity.Space"--%>
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="row">
            <div class="col-sm-6 b-r">
                <h3 class="m-t-none m-b">创建空间</h3>
                <form:form modelAttribute="space" action="${pageContext.request.contextPath}/space/save/${space.id}">
                    <!--<form:input path="creator.id"/>
                    <form:input path="time"/>
                    <form:input path="type"/>
                    -->
                    <div class="form-group">
                    <label>空间名称</label>
                    <form:input path="name"/>
                    </div>
                    <div class="form-group">
                        <label>空间介绍</label>
                        <form:input path="intro"/>
                    </div>
                    <input type="submit" value="保存" class="btn btn-sm btn-primary  m-t-n-xs">
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

