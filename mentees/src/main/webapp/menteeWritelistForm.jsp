<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>menteeWritelistForm</title>
  <link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" href="css/menteeWritelistForm.css">
</head>
<body>
  <c:import url="header.jsp"></c:import>

    <div class="mentoRegisterform">
    <form action="study" method="post">
      <h1>자유 게시판 작성</h1>
      <hr size="4" color="gray"><br>
      <input type="text" name="title" id="userTitle" placeholder="제목을 입력하세요." class="studyTitle" required><br>    
      <textarea name="content" cols="60" rows="5" class="studyArea" placeholder="내용을 입력하세요." required></textarea><br>
      <center><input type="submit" value="제출하기" class="join"></center>    
    </form>
  </div>
  <c:import url="footer.jsp"/>
</body>
</html>