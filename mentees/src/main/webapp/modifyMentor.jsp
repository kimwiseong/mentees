<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%
	String name = request.getParameter("name");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	String subject = request.getParameter("subject");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/modifyMentor.css">
</head>
<body>
  <c:import url="header.jsp"></c:import>
  
  <center><h1 class="pageTitle">멘토 모집 글</h1></center>
  <br><br>
  <hr width="70%" size="4" color="gray" class="line"><br>
  <h3 class="writer">작성자: <%= name %></h3>
  
  <form action="updateRecruit" method="post">
  	<h3 class="mentoTitle"> 제목 : <input type="text" value="<%=title %>" name="title"></h3>
  	<h3 class="content">
  	  <input type="radio" name="subject" value="수학"> 수학
      <input type="radio" name="subject" value="영어"> 영어
      <input type="radio" name="subject" value="코딩"> 코딩
  	</h3>
  	<textarea cols="142" rows="15" class="contentInfo" name="content"><%= content %></textarea>
  	<input type="hidden" name="id" value="<%= id %>"/>
  	<input type="submit" value="수정 완료" class="modify">
  </form>
  
</body>
</html>