<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/2/28
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>space</title>
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
            pageNum--;
            window.location.href="<%=request.getContextPath()%>/space/listByPage.action?pageNum="+pageNum;
        }
        function nextPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            pageNum++;
            if(pageNum==totalPage+1){
                alert("亲，已经是尾页了");
            }
            else{
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
<table border="1">
    <caption>空间表</caption>
    <tr>
        <th>id</th>
        <th>创始人id</th>
        <th>空间名</th>
        <th>类型</th>
        <th>创建时间</th>
        <th>描述</th>
        <th colspan="3">操作</th>
    </tr>
    <c:forEach items="${spaceList}" var="space" >
        <tr>
            <td align = "center">${space.id}</td>
            <td align = "center">${space.creator.name}</td>
            <td align = "center">${space.name}</td>
            <td align = "center">${space.type}</td>
            <td align = "center">${space.time}</td>
            <td align = "center">${space.intro}</td>
            <td align="center" ><a href="${pageContext.request.contextPath}/space/get/${space.id}"><input type="button" value="详情"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/space/edit/${space.id}"><input type="button" value="编辑"></a></td>
            <td align="center" ><a href="${pageContext.request.contextPath}/space/del/${space.id}"><input type="button" value="删除"></a></td>
        </tr>
    </c:forEach>
    <tr>
        <td align="center" ><a href="${pageContext.request.contextPath}/space/add"><input type="button" value="添加"></a></td>
    </tr>
</table>
<div align="center">
    <input type="hidden" id="pageNum" value="${spaceList.getPageNum()}">
    <input type="hidden" id="totalPage" value="${spaceList.getPages()}">
    <span onclick="firstPage()">首页</span>
    <span onclick="prePage()">上一页</span>
    <c:forEach begin="1" end="${spaceList.getPages()}" varStatus="statu">
        <a  href="${pageContext.request.contextPath}/space/listByPage.action?pageNum=${statu.count}">${statu.count}</a>
    </c:forEach>
    <span onclick="nextPage()">下一页</span>
    <span onclick="lastPage()">尾页</span>
</div>
</body>
</html>
