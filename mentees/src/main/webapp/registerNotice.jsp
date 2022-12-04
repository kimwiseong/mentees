<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nav.css">
<link rel="stylesheet" href="css/registerNotice.css">
</head>
<body>
   <%
   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html; charset=utf-8");

   HttpSession session = request.getSession(false);
   String email = (String) session.getAttribute("email");
   if (email == null) {
      out.print("<script>alert('로그인 후 이용해주세요'); location.href='login.jsp'; </script>");
   }
   if (!email.equals("admin"))
      out.print("<script>alert('수정 권한이 필요합니다.'); history.back(); </script>");
   %>
   <c:import url="header.jsp"></c:import>
   <div class="noticeRegisterform">
      <form action="notice" method="post">
         <h1>공지 글 작성</h1>
         <hr size="2" color="gray">
         <br> <input type="text" name="title" placeholder="글 제목을 입력해주세요." class="noticeTitle"
            required><br>
         <textarea name="content" cols="60" rows="5"
            placeholder="글 내용을 입력해주세요." class="noticeArea" required></textarea>
         <br> <center><input type="submit" value="제출하기" class="join"></center>
      </form>
   </div>
</body>
</html>