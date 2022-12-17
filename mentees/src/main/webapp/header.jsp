<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nav.css">
</head>
<body>
	<nav class="navBar">
      <ul>
        <li><a href="<c:url value='main'/>" class="navLogo" style="color: #6C8910;">mentees</a></li>
        <li><a href="<c:url value='notice'/>" class="noticePage">공지 사항</a></li>
        <li><a href="<c:url value='mentrecruit'/>" class="mentoRecruitment">멘토 모집</a></li>
        <li><a href="<c:url value='study'/>" class="menteeRecruitment">자유 게시판</a></li>
        <li><a href="<c:url value='mypage'/>" class="myPage">내정보</a></li> 
        <li><a href="<c:url value='login'/>" class="logout">로그아웃</a></li>
      </ul>
    </nav>
</body>
</html>
