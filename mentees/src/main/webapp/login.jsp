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
  <link rel="stylesheet" href="css/login.css">
</head>
<body>
  <div class="logo">mentees</div>
  <div class="comment">
    멘토링 사이트 mentees에서 당신의 지식을<br>
    공유해 보세요
  </div>
  <div class="loginForm">
    <form method="post">
      <input type="text" name="userId" id = "userId" placeholder="아이디를 입력해주세요." class="idInput" autofocus><br>
      <input type="password" name="userPwd" id="userPwd" placeholder="비밀번호를 입력해주세요." class="pwdInput"><br>
      <input type="submit" value="로그인" class="loginButton"><br>
      <hr size="4" color="gray">
      <button class="makeAccount">계정 만들기</button>
    </form>
  </div>
</body>
</html>