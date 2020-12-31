<%@page import="com.spring.gogidang.member.EventVO"%>
<%@page import="com.spring.gogidang.member.Shop_regVO"%>
<%@page import="com.spring.gogidang.member.ReviewVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%

	String u_id=null;

	if (session.getAttribute("u_id")!=null){
		u_id=(String)session.getAttribute("u_id");
	}else{
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
	
	ArrayList<EventVO> event_list =(ArrayList<EventVO>) request.getAttribute("event_list");
	ArrayList<Shop_regVO> shop_reg_list =(ArrayList<Shop_regVO>) request.getAttribute("shop_reg_list");
	ArrayList<ReviewVO> review_list =(ArrayList<ReviewVO>) request.getAttribute("review_list");
%>
<html>
<head>
<title>회원관리 시스템 메인 페이지</title>
</head>
<body>
<h3><%=u_id %> 로 로그인하셨습니다.</h3>

<center>
	<h3>이벤트 메인사진</h3>
	<a>hello</a>
			<table border=1 width=300>
				
					<%
						for (int i=0; i<event_list.size(); i++)
							{
							EventVO vo = (EventVO)event_list.get(i);
					%>
					<tr align=center>
						<td colspan=2>
							<a href="eventinfo.me?event_num=<%=vo.getEvent_num()%>"><%=vo.getThumbnail() %>
						</td>
					</tr>
					<%
							} 
					%>
				
				
			</table>
			<h3>가게 메인사진</h3>
			<table border=1 width=300>
				<tr align=center>
				<td colspan=2>
					<%
						for (int i=0; i<shop_reg_list.size(); i++)
							{
							Shop_regVO vo1 = (Shop_regVO)shop_reg_list.get(i);
					%>
				
						<%=vo1.getThumbnail()%>
					<%
							} 
					%>
				</td>
				</tr>
				</table>
				<h3>리뷰 닉네임,사진,등록날짜,별점</h3>
				<table border=1 width=300>
				<tr align=center>
				<td colspan=2>
					<%
						for (int i=0; i<review_list.size(); i++)
							{
							ReviewVO vo2 = (ReviewVO)review_list.get(i);
					%>
						<%=vo2.getNickname() %>
						<%=vo2.getPhoto1() %>
						<%=vo2.getRe_date() %>
						<%=vo2.getStar()%>
					<%
							} 
					%>
				</td>
				</tr>
			</table>
			<a href="./eventpage.me">이벤트 페이지</a>
		</center>
</p>
</body>
</html>