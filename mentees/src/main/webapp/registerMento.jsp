<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>          
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>registerMento</title>
  <link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" href="css/registerMento.css">
</head>
<body>
  <c:import url="header.jsp"></c:import>
  
  <div class="mentoRegisterform">
    <form action="mentrecruit" method="post">
      <h1>멘토 신청</h1>
      <hr size="4" color="gray"><br>
      <input type="text" name="title" placeholder="글 제목을 입력해주세요." class="mentoTitle" required><br>
      <input type="radio" name="subject" value="수학" required> 수학
      <input type="radio" name="subject" value="영어"> 영어
      <input type="radio" name="subject" value="코딩"> 코딩
      <br>
      <textarea name="content" cols="60" rows="5" placeholder="글 내용을 입력해주세요." class="mentoArea" required></textarea><br>  
      <center><input type="submit" value="제출하기" class="join"></center>   
    </form>
  </div>
  <c:import url="footer.jsp"/>
</body>
</html>