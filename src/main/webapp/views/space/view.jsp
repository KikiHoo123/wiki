<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <title>BSC-主页</title>
    <!-- css -->
    <link rel="stylesheet" type="text/css"  href="../../tools/lib/semantic/semantic.min.css" />
    <link rel="stylesheet"  href="../../tools/lib/toastr/toastr.css" />
    <link rel="stylesheet" type="text/css"  href="../../tools/css/md-github.css" />
    <link rel="stylesheet" type="text/css"  href="../../tools/css/admin.css" />
</head>
<body class="admin-index">
<div  style="z-index:1992;" class="ui fixed inverted main menu">
    <div class="ui floating top  pointing dropdown link item dd-top-menu-user">
        <span class="ad-index-user-username" >BSC</span>
        <div class="menu">
            <div class="header">选择操作</div>
            <div class="item " >
                <span><a href="${pageContext.request.contextPath}user/home">首页</a></span>
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
                <span><a href="${pageContext.request.contextPath}/team/add" target="main">团队</a></span>
            </div>
            <div class="item ad-index-logout">
                <span><a href="${pageContext.request.contextPath}/wiki/add" target="main">wiki</a></span>
            </div>
        </div>
    </div>
    <div class="search bar7">
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
                <div class="item">
                    <i class="home icon"></i>${space.name}(${space.creator.name})
                </div>
                <a class="item" target="main"  href="${pageContext.request.contextPath}/user/get/${sessionScope.user.id}">
                    <i class="chat icon"></i> 个人信息
                </a>
                <a class="item" target="main"  href="${pageContext.request.contextPath}/interaction/collect/${sessionScope.uer.id}">
                    <i class="wikipedia icon"></i> 收藏空间
                </a>
            </div>
        </div>
        <div id="context" style="background-color: white; padding-top:70px;" >
            <table align="center">
                <caption>${space.name}的详情页</caption>
                <tr>
                    <th>id</th>
                    <th>创始人id</th>
                    <th>空间名</th>
                    <th>类型</th>
                    <th>创建时间</th>
                    <th>描述</th>
                    <th>空间成员</th>
                </tr>
                <tr>
                    <td align = "center">${space.id}</td>
                    <td align = "center">${space.creator.name}</td>
                    <td align = "center">${space.name}</td>
                    <td align = "center">${space.type}</td>
                    <td align = "center">${space.time}</td>
                    <td align = "center">${space.intro}</td>
                    <c:forEach items="${space.smemberList}" var="smember" >
                        <td align = "center">${smember.member.name}<br></td>
                    </c:forEach>
                </tr>
            </table>
            <table align="center">
                <c:forEach items="${wikiList}" var="wiki">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></td>
                        <td>${wiki.creator.name}</td>
                        <td>${wiki.content}</td>
                        <!--${wiki.modifier.name}</td>-->
                        <td>${wiki.lasttime}</td>
                        <td><a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a></td>
                        <td><a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <script type="text/javascript"  src="../../tools/js/deps-base.js"></script>
    <script type="text/javascript"  src="../../tools/js/admin.js"></script>
</div>
</body>
</html>
