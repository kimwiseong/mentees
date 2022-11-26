<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="css/makeAccount.css">
</head>
<body>
  <div class="logo">mentees</div>
  <div class="comment">
    멘토링 사이트 mentees에서 당신의 지식을<br>
    공유해 보세요
  </div>
  <div class="loginForm">
    <form>
      <h1 align="center">회원 가입</h1>
      <hr size="4" color="gray"><br>
      <input type="text" name="userId" id = "userId" placeholder="이름을 입력해주세요. ex) 홍길동" class="loginFormInput" autofocus><br>
      <input type="email" name="userEmail" id="userEmail" placeholder="이메일을 입력해주세요." class="loginFormInput"><br>
      <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호를 입력해주세요." class="loginFormInput"><br>
      <input type="password" name="userPwdCheck" id="userPwdCheck" placeholder="비밀번호를 다시 입력해주세요." class="loginFormInput"><br>
      <input type="submit" value="가입하기" class="join">    
    </form>
  </div>
</body>
</html>