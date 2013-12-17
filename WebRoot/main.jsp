<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>移动APP服务端后台</title>
<META http-equiv=content-type content="text/html; charset=utf-8">
</head>
<FRAMESET rows=105,* cols="*" bordercolor="04376E">
	<FRAME name=ads marginWidth=0 marginHeight=0 src="<%=path%>/top.jsp"
		frameBorder=0 noResize scrolling=no longDesc="">
	<FRAMESET rows=675 cols=198,* frameborder="yes">
		<FRAME name=list marginWidth=0 marginHeight=0 src="<%=path%>/left.jsp"
			frameBorder=0 noResize scrolling=yes longDesc="">
		<FRAME name=main marginWidth=0 marginHeight=0
			src="<%=path%>/postdata.jsp" frameBorder=0 scrolling=yes longDesc="">
	</FRAMESET>
	<NOFRAMES>
		<body></body>
	</NOFRAMES>
</FRAMESET>
</html>
