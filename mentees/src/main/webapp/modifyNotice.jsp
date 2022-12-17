<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<%
String name = request.getParameter("name");
String title = request.getParameter("title");
String content = request.getParameter("content");
String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/modifyNotice.css">
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");

	HttpSession session = request.getSession(false);
	String email = (String) session.getAttribute("email");
	if (email == null) {
		out.print("<script>alert('로그인 후 이용해주세요'); location.href='login.jsp'; </script>");
	}
	if (!email.equals("admin"))
		out.print("<script>alert('수정 권한이 필요합니다.'); history.back(); </script>");
	%>
	
	<c:import url="header.jsp"></c:import>

	<center>
		<h1 class="pageTitle">공지사항</h1>
	</center>
	<br>
	<br>
	<hr width="70%" size="4" color="gray" class="line">
	<br>
	<h3 class="writer">
		작성자:
		<%=name%></h3>

	<form action="updateNotice" method="post">
		<h3 class="noticeTitle">
			제목 : <input type="text" value="<%=title%>" name="title">
		</h3>
		<h3 class="content">글내용</h3>
		<textarea cols="142" rows="15" class="contentInfo" name="content"><%=content%></textarea>
		<input type="hidden" name="id" value="<%=id%>" /> <input
			type="submit" value="수정 완료" class="modify">
	</form>
<c:import url="footer.jsp"/>
</body>
</html>