<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/8
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/tools/css/login.css" rel="stylesheet">
	<script type="text/javascript" src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
</head>

<body class="signin">
<div class="signinpanel">
    <div class="row">
        <div class="col-sm-7">
            <div class="signin-info">
                <div class="logopanel m-b">
                    <h1>WELCOME!</h1>
                </div>
                <div class="m-b"></div>
                <h1><strong>青岛大学商学院维基百科</strong></h1>
            </div>
        </div>
        <div class="col-sm-5">
            <form method="post" name="form1" action="${pageContext.request.contextPath}/sys/login">
                <h4 class="no-margins">登录：</h4>
                <p class="m-t-md"></p>
                <input type="text" name="num" class="form-control uname" placeholder="学号/教工号" />
                <input type="password" name="password" class="form-control pword m-b" placeholder="密码" />
                <a href="">忘记密码？</a>
                <button class="btn btn-success btn-block" onclick="check(form1)">登录</button>
            </form>
        </div>
    </div>
    <div class="signup-footer">
        <div class="pull-left">
            &copy; 2019 All Rights Reserved. WE
        </div>
    </div>
</div>


</body>
</html>
