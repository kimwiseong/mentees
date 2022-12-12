<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/showNoticeList.css">
</head>
<body>
  <c:import url="header.jsp"></c:import>
  
  <center><h1 class="pageTitle">공지사항</h1></center>
  <br><br>
  <hr width="70%" size="4" color="gray" class="line"><br>
  <h3 class="writer">작성자: <a class="nameHover" href="<c:url value='searchMember?name=${notice.name }'/>"> ${notice.name }</a></h3>
  <h3 class="noticeTitle"> 제목 : ${notice.title }</h3>

  <div class="contentInfo">${notice.content }</div>
  
  <form action="deleteNotice" method="post">
    <input type="hidden" name="id" value="${notice.id}"/>
    <input type="submit" value="글 삭제" class="delete">
  </form>

  <form action="modifyNotice.jsp" method="post">
    <input type="hidden" name="name" value="${notice.name} "/>
   	<input type="hidden" name="title" value="${notice.title} "/>
   	<input type="hidden" name="content" value="${notice.content} "/>
  	<input type="hidden" name="id" value="${notice.id} "/>
    <input type="submit" value="글 수정" class="modify">
  </form>
  <c:import url="footer.jsp"/>
</body>
</html>