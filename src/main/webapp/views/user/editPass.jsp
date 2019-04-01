<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/8
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>个人信息</title>
    <script src="<c:url value="/tools/js/jquery.js"/>" type="text/javascript"></script>
    <script>
        $(document).ready(function(){
            $("#bon").click(function () {
                var older = $("#old").val(); // 注意，jquery筛选一定加引号，否则报错uncaught
                var newer = $("#new").val();
                if (older === "" || older == null) {
                    alert("请输入原密码");
                    $("#old").focus();
                } else if (newer === "" || newer == null) {
                    alert("请输入新密码");
                    $("#new").focus();
                } else {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/user/editPwd",  //之前的form.action"../user/editPwd"
                        type: "POST",
                        dataType: 'json',
                        data: $("#form").serialize(),
                        async: false,
                        success: function (result) {
                            if (result.state==0) {
                                $("#old").val("");
                                $("#new").val("");
                                alert(result.message);
                            } else if (result.state==1) {
                                $("#old").val("");
                                $("#new").val("");
                                alert(result.message);
                            } else if (result.state==-1) {
                                $("#old").val("");
                                $("#new").val("");
                                alert(result.message);
                            }
                        }
                    })
                }
            })
        });
    </script>
</head>
<body>
<form id="form">
    <table>
        <tr>
            <td>旧密码</td>
            <td><input type="password" id="old" name="old"></td>
        </tr>
        <tr>
            <td>新密码</td>
            <td><input type="password" id="new" name="new"></td>
        </tr>
        <tr><td colspan="2" align="center"><input name="bon" id="bon" type="button" value="提交" ></td></tr>
    </table>
</form>
</body>
</html>
