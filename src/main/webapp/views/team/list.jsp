<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="${pageContext.request.contextPath}/tools/css/plugins/footable/footable.core.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/style.css" />
<html>
<head>
    <title>团队列表</title>
    <script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
    <script>
        function firstPage(){
            var pageNum=document.getElementById("pageNum").value;
            if(1==pageNum){
                alert("亲，已经是首页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/team/list.action?pageNum="+1;
            }
        }
        function prePage(){
            var pageNum=document.getElementById("pageNum").value;
            if(pageNum==1){
                alert("亲，已经是首页了");
            }
            else{
                pageNum--;
                window.location.href="<%=request.getContextPath()%>/team/list.action?pageNum="+pageNum;}
        }
        function nextPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }
            else{
                pageNum++;
                window.location.href="<%=request.getContextPath()%>/team/list.action?pageNum="+pageNum;}
        }
        function lastPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/team/list.action?pageNum="+totalPage;
            }
        }
    </script>
</head>
<body>
<c:out value="${msg}"/>
<div class="ibox-content">
    <table class="footable table table-stripped" data-page-size="8" data-filter=#filter>
        <thead>
        <tr>
            <td><a href="${pageContext.request.contextPath}/team/add"><input type="button" value="创建团队"></a></td>
        </tr>
        <tr>
            <th>团队名称</th>
            <th>创建时间</th>
            <th>团队描述</th>
            <th colspan="3">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${teamList}" var="team">
            <tr>
                <td><a data-toggle="modal" href="${pageContext.request.contextPath}/team/get/${team.id}">${team.title}</a></td>
                <td>${team.time}</td>
                <td>${team.intro}</td>
                <c:choose>
                <c:when test="${team.creator.id==sessionScope.user.id}">
                <td><a href="${pageContext.request.contextPath}/team/edit/${team.id}">修改</a></td>
                <td><a href="${pageContext.request.contextPath}/team/del/${team.id}">删除</a></td>
                </c:when>
                    <c:otherwise>
                        <td></td>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <input type="hidden" id="pageNum" value="${teamList.getPageNum()}">
    <input type="hidden" id="totalPage" value="${teamList.getPages()}">
    <ul class="pagination">
        <li><a href="#" onclick="firstPage()">首页</a></li>
        <li><a href="#" onclick="prePage()">上一页</a></li>
        <c:forEach begin="1" end="${teamList.getPages()}" varStatus="statu">
            <li><a  href="${pageContext.request.contextPath}/team/list.action?pageNum=${statu.count}">${statu.count}</a></li>
        </c:forEach>
        <li><a href="#" onclick="nextPage()">下一页</a></li>
        <li><a href="#" onclick="lastPage()">尾页</a></li>
    </ul>
</div>
</body>
</html>
