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
        <tbody>
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
            <td width="300px" align="center"><a href="<c:url value='searchMember?name=${ list.name }'/>">${list.name }</a></td>
            <td width="400px" align="center">${list.regDate }</td>
          </tr>
        </c:forEach>
        </tbody>
        
        <tbody>
                <tr>
                    <td colspan="5" align="center">
                         <ul>
                             <!-- 2. 이전버튼 활성화 여부 --> 
                             <c:if test="${page.prev }">
                                 <li><a href="notice?pageNum=${page.start - 1 }&amount=${page.amount}">이전</a></li>
                             </c:if>
                                                               
                                <!-- 1. 페이지번호 처리 --> 
                                <c:forEach var="num" begin="${page.start }" end="${page.end }">
                                    <li  class="${page.pageNum eq num ? 'active' : '' }">
                                    <a href="notice?pageNum=${num }&amount=${page.amount}">${num }</a></li>
                                </c:forEach>
                                
                                <!-- 3. 다음버튼 활성화 여부 --> 
                                <c:if test="${page.next }">
                                    <li><a href="notice?pageNum=${page.end + 1 }&amount=${page.amount}">다음</a></li>
                                </c:if>
                        </ul>
                    </td>
                </tr>
            </tbody>
    </table>
    </div>
  </div>
  <c:import url="footer.jsp"/>
</body>
</html>