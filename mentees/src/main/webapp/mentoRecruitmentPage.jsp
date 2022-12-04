<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>mentoRecruitmentPage</title>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" href="css/mentoRecruitmentPage.css">  
  <script>
    function registMento(){
      location.href = "registerMento.jsp"
    }
  </script>
</head>
<body>
  <c:import url="header.jsp"></c:import>

  <div class="mentoArea">
    <button class="registerMento" onclick="registMento();">멘토 신청하기</button>
    <form action="subject" method="get" class="searchBox">
      <input type="radio" name="subject" value="수학" required> 수학
      <input type="radio" name="subject" value="영어"> 영어
      <input type="radio" name="subject" value="코딩"> 코딩
      <input type="radio" name="subject" value="none"> 선택없음
      <input type="submit" value="검색" class="searchButton">
    </form>
    <hr width="70%" size="4" color="gray" class="line"><br>
    <div class="mentoLists">
    <table>
    	<tr align="center">
    		<td width="100px">글 번호</td>
    		<td width="300px">제목</td>
    		<td width="300px">작성자</td>
    		<td width="400px">작성일</td>	
    	</tr>
        <c:forEach items="${mentorList}" var="list">
          <tr>
            <td width="100px" align="center">${list.id }</td>
            <td width="300px" align="center"><a href="<c:url value='readRecruit?id=${ list.id }'/>">${list.title }</a></td>
            <td width="300px" align="center">${list.name }</td>
            <td width="400px" align="center">${list.regDate }</td>
          </tr>
        </c:forEach>
    </table>
    </div>
  </div>
</body>
</html>