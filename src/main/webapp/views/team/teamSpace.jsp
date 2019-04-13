<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/4/2
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <title>${space.name}</title>
    <!-- css -->
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/lib/semantic/semantic.min.css" />
    <link rel="stylesheet"  href="${pageContext.request.contextPath}/tools/lib/toastr/toastr.css" />
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/md-github.css" />
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/admin.css" />
    <script>
        function collect() {
            x=document.getElementById("collect");
            if (x=="收藏"){
                x.innerHTML="已收藏";
            }
            else x.innerHTML="收藏";
        }
    </script>
</head>
<body class="admin-index">
<div  style="z-index:1992;" class="ui fixed inverted main menu">
    <div class="ui floating top  pointing dropdown link item dd-top-menu-user">
        <span class="ad-index-user-username" >BSC</span>
        <div class="menu">
            <div class="header">选择操作</div>
            <div class="item " >
                <span><a href="${pageContext.request.contextPath}/sys/home">首页</a></span>
            </div>
            <div class="item ">
                <span><a href="#">青岛大学官网</a></span>
            </div>
        </div>
    </div>
    <a class="title item">
        <b>青岛大学商学院维基百科</b>
    </a>
    <div class="ui floating top  pointing dropdown link item dd-top-menu-user">
        <div class="ad-index-user-username">创建 </div>
        <div class="menu">
            <div class="header">选择操作</div>
            <div class="item ad-index-user-edit" >
                <span><a href="${pageContext.request.contextPath}/team/add" target="_blank">团队</a></span>
            </div>
            <div class="item ad-index-logout">
                <span><a href="${pageContext.request.contextPath}/wiki/add/${space.id}" target="_blank">wiki</a></span>
            </div>
        </div>
    </div>
    <div class="search bar7">
        <!--ATTENTION! 这里完成在当前空间搜索-->
        <form>
            <input type="text" placeholder="请输入关键字" name="crid">
            <button type="submit"></button>
        </form>
    </div>
    <div class="right menu">
        <div class="ui floating top right pointing dropdown link item dd-top-menu-user">
            <i class="user icon"></i>
            <span class="ad-index-user-username" >${sessionScope.user.name}</span>
            <div class="menu">
                <div class="header">选择操作</div>
                <div class="item ad-index-user-edit" >
                    <i class="edit icon"></i>
                    <span><a href="${pageContext.request.contextPath}/user/get/${sessionScope.user.id}" target="main">个人信息</a> </span>
                </div>
                <div class="item ad-index-user-username" >
                    <i class="edit icon"></i>
                    <span><a href="${pageContext.request.contextPath}/user/" target="main">个人空间</a> </span>
                </div>
                <div class="item ad-index-logout">
                    <i class="sign out icon"></i>
                    <span><a href="${pageContext.request.contextPath}/user/loginOut">退出 </a> </span>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="pusher ad-index-content">
    <div class="ad-index-container">
        <div  class="ui dividing close left rail ad-index-rail" style="width:133px; height:450px; padding-top:70px;">
            <div  class="ui vertical pointing inverted menu" style="width: 9rem !important; position: fixed;">
                <div class="item"><!--点击进入个人空间？-->
                    <i class="star icon"></i>${space.name}
                    (${space.creator.name})
                </div>
            </div>
        </div>
        <div id="context" style="background-color: white; padding-top:70px;" >
            <iframe name="main" src="${pageContext.request.contextPath}/space/get/${space.id}" style="width:100%; min-height:500px" frameborder="no">
            </iframe>
        </div>
    </div>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/tools/js/deps-base.js"></script>
    <script type="text/javascript"  src="${pageContext.request.contextPath}/tools/js/admin.js"></script>
</div>
</body>
</html>

