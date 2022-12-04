<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>menteeRecruitmentPage</title>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" href="css/menteeRecruitmentPage.css">
  <script>
    function writeList(){
      location.href = "menteeWritelistForm.jsp"
    }
  </script>
</head>
<body>
  <c:import url="header.jsp"></c:import>

 <div class="menteeArea">
    <button class="writeList" onclick="writeList(); return false;">글 등록</button>
	<form action="studysearch" method="post">
	    <input name="query" type="search" placeholder="검색어를 입력해주세요." class="searchBox">
    	<input type="submit" value="검색" style="font-family: 'yg-jalnan';" class="searchButton">
	</form>
    <hr width="70%" size="4" color="gray" class="line"><br>
    
    <div class="menteeLists">
    <table>
    	<tr align="center">
    		<td width="100px">글 번호</td>
    		<td width="300px">제목</td>
    		<td width="300px">작성자</td>
    		<td width="400px">작성일</td>	
    	</tr>
        <c:forEach items="${studyList}" var="list">
          <tr>
            <td width="100px" align="center">${list.id }</td>
            <td width="300px" align="center"><a href="<c:url value='readStudy?id=${ list.id }'/>">${list.title }</a></td>
            <td width="300px" align="center">${list.name }</td>
            <td width="400px" align="center">${list.regDate }</td>
          </tr>
        </c:forEach>
    </table>
    </div>
  </div>
</body>
</html>