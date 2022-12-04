<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입</title>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="css/makeAccount.css">
</head>
<body>
  <div class="logo"><a href="login.jsp">mentees</a></div>
  <div class="comment">
    멘토링 사이트 mentees에서 당신의 지식을<br>
    공유해 보세요
  </div>
  
  <div class="joinForm">
    <form method="post" action="join">
      <h1>회원 가입</h1>
      <hr size="2" color="gray"><br>
      <input type="text" name="name" id = "name" placeholder="이름을 입력해주세요. ex) 홍길동" class="inputStyle" autofocus><br>
      <input type="email" name="email" id="email" placeholder="이메일을 입력해주세요." class="inputStyle"><br>
      <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요." class="inputStyle"><br>
      <input type="password" name="passwordCheck" id="passwordCheck" placeholder="비밀번호를 다시 입력해주세요." class="inputStyle"><br>
      <input type="submit" value="가입하기" class="join">
      
    </form>
  </div>
  </body>
</html>