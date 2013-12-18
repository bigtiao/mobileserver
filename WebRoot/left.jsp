<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>后台管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="" name=keywords>
<META content=name=description>
<STYLE type=text/css>
.neon {
	FILTER: glow(color =   #FFFFFF, strength =       3)
}

DIV {
	WIDTH: 70px
}

BODY {
	MARGIN: 0px;
	background-color: #005fc5;
}

BODY {
	MARGIN-TOP: 0px;
	SCROLLBAR-FACE-COLOR: #005fc5;
	FONT-SIZE: 12px;
	BACKGROUND: #FFFFFF;
	SCROLLBAR-HIGHLIGHT-COLOR: #799ae1;
	SCROLLBAR-SHADOW-COLOR: #799ae1;
	SCROLLBAR-3DLIGHT-COLOR: #005fc5;
	SCROLLBAR-ARROW-COLOR: #ffffff;
	SCROLLBAR-TRACK-COLOR: #aabfec;
	SCROLLBAR-DARKSHADOW-COLOR: #799ae1
}
</STYLE>
<LINK href="<%=path%>/images/duan_1.css" type=text/css rel=stylesheet>
<META content="MSHTML 6.00.2800.1106" name=GENERATOR>
<style type="text/css">
<!--
.style6 {
	COLOR: #0000ff
}

.STYLE7 {
	COLOR: #003366;
	font-size: 12px;
}
-->
</style>
<script type="text/JavaScript">
<!--
	function MM_preloadImages() { //v3.0
		var d = document;
		if (d.images) {
			if (!d.MM_p)
				d.MM_p = new Array();
			var i, j = d.MM_p.length, a = MM_preloadImages.arguments;
			for (i = 0; i < a.length; i++)
				if (a[i].indexOf("#") != 0) {
					d.MM_p[j] = new Image;
					d.MM_p[j++].src = a[i];
				}
		}
	}
//-->
</script>
</HEAD>
<BODY>
	<TABLE height=100% cellSpacing=0 cellPadding=0 width=178 align=center
		border=0>
		<TBODY>
			<TR>
				<TD colSpan=2 height=2></TD>
			</TR>
			<TR>
				<TD width=177 height="682" vAlign=top
					background="<%=path%>/images/glmbxm.png"><img
					src="<%=path%>/images/glmb.png" width="177" height="19">
					<TABLE cellSpacing=1 cellPadding=2 width=177  height=26
						background="<%=path%>/images/abj.png" border=0>
						<TBODY>
							<TR>
								<TD class=unnamed1-dh
									onmouseover="this.style.backgroundColor='#33cc3a'"
									onmouseout="this.style.backgroundColor='#046c13'" vAlign=top>
									<TABLE height=2 cellSpacing=0 cellPadding=0 width="100%"
										border=0>
										<TBODY>
											<TR>
												<TD></TD>
											</TR>
										</TBODY>
									</TABLE> <IMG height=9 src="<%=path%>/images/dhjt.gif" width=15>
									<A class=baise href="#">产品管理模块</A><A class=baise href="#"></A>
								</TD>
							</TR>
						</TBODY>
					</TABLE>


					<TABLE height=26 cellSpacing=1 cellPadding=0 width=177
						background="<%=path%>/images/abj-2.png" border=0>
						<TBODY>
							<TR>
								<TD class=unnamed1-dh
									onmouseover="this.style.backgroundColor='#5fc864'"
									onmouseout="this.style.backgroundColor='#8ace8d'" vAlign=top
									bgColor=#8ace8d
									><A
									href="<%=path%>/servlet/ProductAction?action_flag=list&pageNum=1"
									target="main" class=yd style=" color:#ffffff" >产品信息</A>
								</TD>
							</TR>
						</TBODY>
					</TABLE> <br> <br>
				</TD>
				<TD width=590></TD>
			</TR>
		</TBODY>
	</TABLE>
</BODY>
</HTML>
