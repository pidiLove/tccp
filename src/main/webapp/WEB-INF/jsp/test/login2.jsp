<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
out.println(path);
out.println(basePath);

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP index.jsp  page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>

  <body>
    <h1>login page</h1>  
    <form id="" action="dologin" method="post">  
        <label>User Name</label> <input tyep="text" name="userName"  
            maxLength="40" /> <label>Password</label><input type="password"  
            name="password" /> 
            <li>验证码：<input type="text" name="validateCode" />&nbsp;&nbsp;
            <img id="validateCodeImg" src="<%=basePath%>/validateCode" />
            &nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a>
            </li><input type="submit" value="login" />  
    </form>  
    <%--用于输入后台返回的验证错误信息 --%>  
    <P><c:out value="${message }" /></P>  
  </body>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript">
    //<!--
    function reloadValidateCode(){
        $("#validateCodeImg").attr("src","<%=basePath%>/validateCode?data=" + new Date() + Math.floor(Math.random()*24));
    }
    //-->
    </script>
</html>