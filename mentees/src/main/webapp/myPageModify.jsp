<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%request.setCharacterEncoding("UTF-8"); %>
<%
	String memberIntro = request.getParameter("myIntro");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myPage 수정하기</title>
  <link rel="stylesheet" href="css/myPage.css">
  <link rel="stylesheet" href="css/myPageModify.css">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<h1 class="changeMyIntro">내정보 수정</h1>
  	<div class="modifyPageForm">
    	<form action="mypage" method="post">
      		<textarea cols="60" rows="5" placeholder="수정할 내용을 입력해주세요." name="intro" class="memberIntro"><%= memberIntro %></textarea><br>
      		<input type="submit" value="수정하기" class="join">   
    	</form>
  </div>
</body>
</html>