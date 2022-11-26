<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/nav.css">
    <link rel="stylesheet" href="css/mainPage.css">
    <link rel="stylesheet" href="css/footer.css">
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <style>
      .logo{
        position: absolute;
        left: 20%;
        top: 20%;
        font-size: 3vw;
        color:  #5f9c25;
      }
      .comment{
        position: absolute;
        left: 20%;
        top: 30%;
        font-size: 2vw;
      }
    </style>
    <title>mainPage</title>
  </head>
  <body>
    <nav class="navBar">
      <ul>
        <li><a href="mainpage.html" class="navLogo" style="color: #5f9c25;">mentees</a></li>
        <li><a href="noticePage.html" class="noticePage">공지 사항</a></li>
        <li><a href="mentoRecruitmentPage.html" class="mentoRecruitment">멘토 모집</a></li>
        <li><a href="menteeRecruitmentPage.html" class="menteeRecruitment">멘티 모집</a></li>
        <li><a href="myPage.html" class="myPage">내정보</a></li>      
      </ul>
    </nav>

    <contents class="contents">
      <div class="logo">mentees</div>
      <div class="comment">
        멘토링 사이트 mentees에서 당신의 지식을<br>
        공유해 보세요
      </div>

      <div class="noticeView">
        <h1 style="font-size: 1.5vw;">공지 사항</h1>
        <hr size="4" color="gray">
        <ul>
          <li><a href="noticePage.html">(공지) 멘토 신청 및 멘토 모집</a></li>
          <li><a href="noticePage.html">(공지) 멘토 & 멘티 글 양식</a></li>
        </ul>
      </div>

      <div class="mentoView">
        <h1 style="font-size: 1.5vw;">멘토 모집</h1>
        <hr size="4" color="gray">
        <ul>
          <li><a href="#">[수학] 수학 멘토모집합니다</a></li>
          <li><a href="#">[코딩] 코딩 멘토모집합니다</a></li>
        </ul>
      </div>

      <div class="menteeView">
        <h1 style="font-size: 1.5vw;">멘티 모집</h1>      
        <hr size="4" color="gray">
        <ul>
          <li><a href="#">[프로그래밍] 웹프로그래밍 멘티 모집</a></li>
          <li><a href="#">[C++] C++ 멘티 모집</a></li>
          <li><a href="#">[Java] Java 멘티 모집</a></li>
        </ul>
      </div>
    </contents>
	<div id='wrap'>
        <footer>
          <nav>
          	  <a>Contact</a> |
              <a href='#' target='_blank'>blog</a>
              <a href='https://github.com/wiseong' target='_blank'>WiSeong's github</a> |
              <a href='https://singularity7606.tistory.com' target='_blank'>blog</a>
              <a href='https://github.com/jun6292' target='_blank'>WonJun's github</a> |
              <a href='#' target='_blank'>blog</a>
              <a href='https://github.com/TaeYoonKimMe' target='_blank'>TaeYoon's github</a> |
          </nav>
          <p>
              <span>author : 김위성, 조원준, 김태윤</span><br/>
              <span>e-mail : kys00919@gmail.com, c68254@gmail.com, xodbsrla1352@gamil.com</span><br/>
              <span>Copyright © DGU.CSE.WebProject.Mentees. All Rights Reserved.</span>
          </p>
      </footer>
    </div>
  </body>
</html>