<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>后台新闻管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="" name=keywords>
<META content=name=description>
<STYLE type=text/css>
.neon {
	FILTER: glow(color = #002E60, strength = 3)
}

DIV {
	WIDTH: 70px
}

BODY {
	MARGIN: 0px
}

BODY {
	MARGIN-TOP: 0px;
	SCROLLBAR-FACE-COLOR: #005fc5;
	FONT-SIZE: 12px;
	BACKGROUND: #ffffff;
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
.STYLE7 {
	COLOR: #003366;
	font-size: 12px;
}
-->
</style>


<script type="text/javascript">
 function dosubmit(){
   var th = document.form1;
   th.action="<%=path%>/servlet/UserAction?action_flag=add";
		th.submit();
	}
</script>

<!-- enctype="multipart/form-data" -->
</HEAD>
<BODY bgColor="#ffffff">
	<form name="form1" action="" method="post">
		<TABLE height=426 cellSpacing=0 cellPadding=0 width=580 align=center
			border=0>
			<TBODY>
				<TR>
					<TD colSpan=3 height=9></TD>
				</TR>
				<TR>
					<TD vAlign=top width=12 background="<%=path%>/images/dhpddw.gif"
						rowSpan=2>&nbsp;</TD>
					<%-- <TD width=739 background="<%=path%>/images/h-1.gif" height=9></TD>
					<TD width=9 height=9><IMG height=9
						src="<%=path%>/images/jiao.gif" width=9>
					</TD>
					--%>
				</TR>
				<TR>
					<TD vAlign=top align=right width=739 height=408><TABLE
							cellSpacing=0 cellPadding=0 width=556 border=0>
							<!--DWLayoutTable-->
							<TBODY>
								<TR>
									<TD vAlign=bottom width=548 height=27><IMG height=10
										src="<%=path%>/images/jt2.gif" width=10> <span
										class="lbt">信息管理&gt;&gt;信息_添加 </span>
									</TD>
									<TD width=8 rowSpan=3>&nbsp;</TD>
								</TR>
								<TR>
									<TD background="<%=path%>/images/ht.gif" height=22></TD>
								</TR>
								<TR>
									<TD class=unnamed1 vAlign=top height=9><TABLE width="99%"
											border=0 cellPadding=4 cellSpacing=1 bgColor=#0867b3>
											<TBODY>
												<TR bgColor=#ffffff height=20>
													<TD width=13% align="center" noWrap class="STYLE7">姓名</TD>
													<TD width=31% noWrap><span class="foot3"> <INPUT
															class=text2 maxLength=100 size=18 name="name"
															minLength="1">
													</span>
													</TD>
													<TD width=18% align="center" noWrap class="STYLE7">公司</TD>
													<TD width=38% noWrap><span class="STYLE7"> <%-- <INPUT
															class=text2 maxLength=200 size=18 name="company"
															minLength="1">--%>
													</span>
													<select class=text2 length=200  name="company">
														<option>控股公司</option>
														<option>粮油公司</option>
														<option>小包装公司</option>
														<option>龙口公司</option>
														<option>蛋白公司</option>
														<option>健源公司</option>
														<option>热动公司</option>
														<option>物流公司</option>
														<option>物流项目公司</option>
														<option>饲料公司</option>
														<option>置业公司</option>
														<option>典当公司</option>
														<option>北京公司</option>
														<option>中华人民共和国公司</option>
													</select>
													
													</TD>
												</TR>

												<TR bgColor=#ffffff height=20>
													<TD width=13% align="center" noWrap class="STYLE7">部门</TD>
													<TD width=31% noWrap><span class="foot3"> <INPUT
															class=text2 maxLength=100 size=18 name="department"
															minLength="1">
													</span>
													</TD>
													<TD width=13% align="center" noWrap class="STYLE7">电话</TD>
													<TD width=31% noWrap><span class="foot3"> <input
															class="Wdate" name="phonenum" type="text"
															>
													</TD>
												</TR>
											</TBODY>
										</TABLE> <br>
									</TD>
								</TR>
								<TR>
									<TD height=27 colspan="2" align="center" vAlign=top><a
										href="javascript:dosubmit();"><img
											src="<%=path%>/images/ok_1.jpg" name="Image3" width="60"
											height="22" border="0">
									</a> <a href="javascript:history.back();"><img
											src="<%=path%>/images/fh_1.jpg" name="Image4" width="60"
											height="22" border="0">
									</a>
									</TD>
								</TR>
								<TR>
									<TD height=87 vAlign=top>
										<!--DWLayoutEmptyCell-->&nbsp;</TD>
									<TD></TD>
								</TR>
								<TR>
									<TD height=20>&nbsp;</TD>
									<TD></TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=9 background="<%=path%>/images/s-1.gif"></TD>
				</TR>
			</TBODY>
		</TABLE>
	</form>
	<IFRAME name=top align=default src="<%=path%>/bottom.jsp"
		frameBorder=0 width=100% scrolling=no height=88>
		<h1>&nbsp;</h1>
	</IFRAME>
</BODY>
</HTML>

