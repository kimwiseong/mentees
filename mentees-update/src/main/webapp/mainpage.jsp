<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/nav.css">
<title>mainPage</title>
<link rel="stylesheet" href="css/mainPage.css">
<style>

a:visited{
   color:black;
}
</style>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
   <nav class="navBar">
      <ul>       
        <li><a href="<c:url value='notice'/>" class="noticePage">공지 사항</a></li>
        <li><a href="<c:url value='mentrecruit'/>" class="mentoRecruitment">멘토 모집</a></li>
        <li><a href="<c:url value='study'/>" class="menteeRecruitment">자유 게시판</a></li>
        <li><a href="<c:url value='mypage'/>" class="myPage">내정보</a></li> 
        <li><a href="<c:url value='login'/>" class="logout">로그아웃</a></li>
      </ul>
    </nav>
    
   <contents>
   <div class="logo">mentees</div>
   <div class="comment">
      멘토링 사이트 mentees에서 당신의 지식을<br> 공유해 보세요
   </div>


     <div class="noticeView">
      <h1 style="font-size: 1.5vw;">공지 사항</h1>
      <hr size="4" color="gray">   
      <c:forEach items="${noticeList}" var="list" begin="0" end="5">
          <tr>
            <td width="30px" align="center"><a href="<c:url value='readnotice?id=${ list.id }'/>">${list.title }</a></td>
          </tr>
          <br>
        </c:forEach>
      </div>
      
      <div class="mentoView">
        <h1 style="font-size: 1.5vw;">멘토 모집</h1>
        <hr size="4" color="gray">   
      <c:forEach items="${mentorList}" var="list" begin="0" end="5">
          <tr>
            <td width="30px" align="center"><a href="<c:url value='readRecruit?id=${ list.id }'/>">${list.title }</a></td>
          </tr>
          <br>
        </c:forEach>
      </div>

      <div class="menteeView">
        <h1 style="font-size: 1.5vw;">자유 게시판</h1>      
        <hr size="4" color="gray">
       
       <c:forEach items="${studyList}" var="list" begin="0" end="5">
          <tr>
            <td width="30px" align="center"><a href="<c:url value='readStudy?id=${ list.id }'/>">${list.title }</a></td>
          </tr>
          <br>
        </c:forEach>
      </div>
    </contents>
<c:import url="footer.jsp"/>
</body>
</html>