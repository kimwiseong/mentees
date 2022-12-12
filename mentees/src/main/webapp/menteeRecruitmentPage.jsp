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
        <tbody>
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
            <td width="300px" align="center" class="nameHover"><a href="<c:url value='searchMember?name=${ list.name }'/>">${list.name }</a></td>
            <td width="400px" align="center">${list.regDate }</td>
          </tr>
        </c:forEach>
        </tbody>
    </table>
    <div align="center" class="page">
    	<ul>
                             <!-- 2. 이전버튼 활성화 여부 --> 
              <c:if test="${page.prev }">
                  <li><a href="study?pageNum=${page.start - 1 }&amount=${page.amount}">이전</a></li>
              </c:if>
                                                               
                                <!-- 1. 페이지번호 처리 --> 
              <c:forEach var="num" begin="${page.start }" end="${page.end }">
                  <li class="paging" class="${page.pageNum eq num ? 'active' : '' }">
                  <a href="study?pageNum=${num }&amount=${page.amount}">${num }</a></li>
              </c:forEach>
                                
                                <!-- 3. 다음버튼 활성화 여부 --> 
              <c:if test="${page.next }">
                  <li><a href="study?pageNum=${page.end + 1 }&amount=${page.amount}">다음</a></li>
              </c:if>
       </ul>
    </div>
    </div>
  </div>
  <div class="ft"><c:import url="footer.jsp"/></div>
</body>
</html>