<%--
  Created by IntelliJ IDEA.
  User: Louis
  Date: 2022/9/7
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath",contextPath);
%>
<html>
<head>
    <script src="${contextPath }/statics/js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#userName").blur(function (){
               var userName = $(this).val();
               $.post("docreateUser.html",{
                   uName:userName
               }, function(data) {
                   if(data=="true"){
                        $("#s1").html("当前用户已存在,更换用户名!");
                   }else{
                       $("#s1").html("当前用户不存在,可以注册!");
                   }
               }, "text");
            });
        });
    </script>
    <title>Title</title>
</head>
<body>
    <p>
        <span>输入用户名:</span>
        <span><input type="text" id="userName" name="userName"></span>
        <span id="s1"></span>
    </p>
<p>
    <span>输入密码:</span>
    <span><input type="password" name="UserPwd" id="UserPwd"></span>
    <span id="s2"></span>
</p>
</body>
</html>
