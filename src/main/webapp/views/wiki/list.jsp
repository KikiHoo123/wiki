<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--
  Created by IntelliJ IDEA.
  User: HUKE
  Date: 2019/3/1
  ResetTime: 15:21
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>wiki列表</title>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/tools/css/style.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/tools/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/tools/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/tools/js/bootstrap.min.js"></script>
<script>
        function firstPage(){
            var pageNum=document.getElementById("pageNum").value;
            if(1==pageNum){
                alert("亲，已经是首页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/wiki/listByPage.action?pageNum="+1;
            }
        }
        function prePage(){
            var pageNum=document.getElementById("pageNum").value;
            //  pageNum--;
            // window.location.href = "<%=request.getContextPath()%>/wiki/listByPage.action?pageNum=" + pageNum;
            if(pageNum==1){
                alert("亲，已经是首页了");
            }
            else{
                pageNum--;
                window.location.href="<%=request.getContextPath()%>/wiki/listByPage.action?pageNum="+pageNum;}
        }
        function nextPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }
            else{
                pageNum++;
                window.location.href="<%=request.getContextPath()%>/wiki/listByPage.action?pageNum="+pageNum;}
        }
        function lastPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                alert("亲，已经是尾页了");
            }else{
                window.location.href="<%=request.getContextPath()%>/wiki/listByPage.action?pageNum="+totalPage;
            }
        }
    </script>
</head>
<body >
<c:out value="${msg}"/>
<table align="center">
    <c:forEach items="${wikiList}" var="wiki">
    <div class="search-result">
        <h3><a href="${pageContext.request.contextPath}/wiki/get/${wiki.id}">${wiki.title}</a></h3>
        <a href="search_results.html#" class="search-link">‎${wiki.space.name}</a>
        <p>${wiki.content}
        </p>
        <a href="${pageContext.request.contextPath}/wiki/edit/${wiki.id}">修改</a>
        <a href="${pageContext.request.contextPath}/wiki/del/${wiki.id}">删除</a>
    </div>
        <div class="hr-line-dashed"></div>
    </c:forEach>
</table>
<div align="center">
    <input type="hidden" id="pageNum" value="${wikiList.getPageNum()}">
    <input type="hidden" id="totalPage" value="${wikiList.getPages()}">
    <ul class="pagination">
        <li><a href="#" onclick="firstPage()">首页</a></li>
        <li><a href="#" onclick="prePage()">上一页</a></li>
        <c:forEach begin="1" end="${wikiList.getPages()}" varStatus="statu">
            <li><a  href="${pageContext.request.contextPath}/wiki/listByPage.action?pageNum=${statu.count}">${statu.count}</a></li>
        </c:forEach>
        <li><a href="#" onclick="nextPage()">下一页</a></li>
        <li><a href="#" onclick="lastPage()">尾页</a></li>
    </ul>
</div>
</body>
</html>

