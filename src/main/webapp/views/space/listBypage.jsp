<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link href="${pageContext.request.contextPath}/tools/css/plugins/footable/footable.core.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/style.css" />
<html>
<head>
    <title>space</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
    <script>
        function firstPage(){
            var pageNum=document.getElementById("pageNum").value;
            if(1==pageNum){
                alert("亲，已经是首页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/space/listByPage.action?pageNum="+1;
            }
        }
        function prePage(){
            var pageNum=document.getElementById("pageNum").value;
            if(pageNum==1){
                alert("亲，已经是首页了");
            }
            else{
                pageNum--;
                window.location.href="<%=request.getContextPath()%>/space/listByPage.action?pageNum="+pageNum;}
        }
        function nextPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }
            else{
                pageNum++;
                window.location.href="<%=request.getContextPath()%>/space/listByPage.action?pageNum="+pageNum;}
        }
        function lastPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/space/listByPage.action?pageNum="+totalPage;
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
            <td><a href="${pageContext.request.contextPath}/space/add"><input type="button" value="创建空间"></a></td>
        </tr>
        <tr>
            <th>空间名</th>
            <th>描述</th>
            <th>创建时间</th>
            <th colspan="2">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${spaceList}" var="space" >
            <tr>
                <td><a href="${pageContext.request.contextPath}/team/detail/${space.id}" target="_parent">${space.name}</a></td>
                <td>${space.intro}</td>
                <td>${space.time}</td>
                <td><a href="${pageContext.request.contextPath}/space/edit/${space.id}"><input type="button" value="编辑"></a></td>
                <td><a href="${pageContext.request.contextPath}/space/del/${space.id}"><input type="button" value="删除"></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div align="center">
    <input type="hidden" id="pageNum" value="${spaceList.getPageNum()}">
    <input type="hidden" id="totalPage" value="${spaceList.getPages()}">
    <ul class="pagination">
        <li><a href="#" onclick="firstPage()">首页</a></li>
        <li><a href="#" onclick="prePage()">上一页</a></li>
        <c:forEach begin="1" end="${spaceList.getPages()}" varStatus="statu">
            <li><a  href="${pageContext.request.contextPath}/space/listByPage.action?pageNum=${statu.count}">${statu.count}</a></li>
        </c:forEach>
        <li><a href="#" onclick="nextPage()">下一页</a></li>
        <li><a href="#" onclick="lastPage()">尾页</a></li>
    </ul>
</div>
</body>
</html>
