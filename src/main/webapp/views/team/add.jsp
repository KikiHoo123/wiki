<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 11:19
  To change this template use File | Settings | File Templates.
--%>
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
<%--@elvariable id="team" type="com.bsc.modules.team.entity.Team"--%>
<div class="ibox float-e-margins">
    <div class="ibox-content">
        <div class="row">
            <div class="col-sm-6 b-r">
                <h3 class="m-t-none m-b">创建团队</h3>
                <form:form modelAttribute="team"  action="${pageContext.request.contextPath}/team/save">
                        <!--<tr>
            <td>creator</td>
            <td><form:input path="creator.id"/></td>
        </tr>
        <tr>
            <td>time</td>
            <td><form:input path="time"/></td>
        </tr>--><div class="form-group">
                        <label>团队名称</label>
                            <form:input path="title"/>
                    </div>
                        <div class="form-group">
                            <label>团队介绍</label>
                            <form:input path="intro"/>
                        </div>
                        <div class="form-group">
                            <label>选择成员</label>
                            <select name="tmember" multiple="multiple">
                                <c:forEach var="user" items="${userList}">
                                    <option value="${user.id}">${user.name}(${user.num})</option>
                                </c:forEach>
                            </select>
                        </div>
                          <input type="submit" value="保存" class="btn btn-sm btn-primary  m-t-n-xs">
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
