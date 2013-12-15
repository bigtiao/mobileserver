<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<style type="text/css">
</style>
<title>移动APP服务端</title>
<script language="javascript">
 function login(){
 var th = document.Login;
  with(th){
   var user=th.username.value;
   var pass=th.password.value;
   if(user==null||user==""){
    alert("请填写用户名");
    }
    else if(pass==null||pass==""){
     alert("请填写密码");
     }
    else th.action="<%=path%>/servlet/LoginAction";
    th.submit();
   }
  }
</script>


</head> 

<body bgcolor = "#D4D4D4"  align = "center">

	<table align="center">
	<tr>
	<img src="images/logo_500.png" >
	</tr>
	</table>

 <form method="POST" name="Login" action="HelloServlet" style="text-align:center">
   <p align="center">
   用户名<input name="username" type="text"  size="20">
   </p>
   <p align="center">
   密 &nbsp码<input name="password" type="password"  size="20">
   </p>
   <p align="center">
   <input type="button" value="提交" name="B1" onClick="login()">
   <input type="reset" value="重置" name="B2"></p>
 </form>

</body>

</html>