<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<link rel="stylesheet" href="css/showMenteeList.css">
</head>
<body>
<section class="info">
  <c:import url="header.jsp"></c:import>  

  <center>
    <h1 class="pageTitle">자유 게시판</h1>
  </center>
  <br><br>
  <hr width="70%" size="4" color="gray" class="line"><br>
  <h3 class="writer">작성자: <a class="nameHover" href="<c:url value='searchMember?name=${study.name }'/>"> ${study.name }</a></h3>
  <h3 class="menteeTitle"> 제목 : ${study.title }</h3>
  <h3 class="content"></h3>
  <div class="contentInfo">${study.content }</div>

  <form action="deleteStudy" method="post">
    <input type="hidden" name="id" value="${study.id}"/>
    <input type="submit" value="글 삭제" class="delete">
  </form>
  
  
  <form action="checkStudy" method="post">
    <input type="hidden" name="name" value="${study.name} "/>
      <input type="hidden" name="title" value="${study.title} "/>
      <input type="hidden" name="content" value="${study.content} "/>
     <input type="hidden" name="id" value="${study.id} "/>
    <input type="submit" value="글 수정" class="modify">
  </form>  
</section>

<section class="reply">
    <form action="insertStudyComments" method="post">
      댓글 작성 <input type="text" name="content" class="replyArea" placeholder="댓글을 입력하세요.">
      <input type="hidden" name="studyId" value="${study.id}">   
      <input type="submit" value="댓글 등록" class="submitReply">
    </form><br>
   
     <table>
     <tbody>
      <tr>
        <td width=70>번호</td>
        <td width=500>댓글</td>
        <td width=200>작성자</td>
        <td width=150>작성일자</td>
        <td width=70></td>
      </tr>
         <c:forEach items="${comments}" var="list">
          <tr>
            <td width=70>${list.id }</td>
            <td width=500>${list.content }</td>
            <td width=200 class="nameHover"><a href="<c:url value='searchMember?name=${list.name }'/>"> ${list.name }</a></td>
            <td width=150>${list.regDate }</td>
            <td width=70>
            <form action="deleteStudyComments" method="post" >
            <input type="hidden" name="id" value="${list.id}"/>
            <input type="hidden" name="commentName" value="${list.name}"/>
            <input type="hidden" name="studyId" value="${list.studyId}"/>
            <input type="submit" value="댓글 삭제">
            </form>
            </td>
          </tr>
          <br>
        </c:forEach>
        </tbody>
        </tbody>
            <tbody>
                <tr>
                    <td colspan="5" align="center">
                         <ul>
                             <c:if test="${page.prev }">
                                 <li><a href="readStudy?id=${study.id }&pageNum=${page.start - 1 }&amount=${page.amount}">이전</a></li>
                             </c:if>
                                                               
                                <c:forEach var="num" begin="${page.start }" end="${page.end }">
                                    <li  class="${page.pageNum eq num ? 'active' : '' }">
                                    <a href="readStudy?id=${study.id }&pageNum=${num }">${num }</a></li>
                                </c:forEach>
                                
                                <c:if test="${page.next }">
                                    <li><a href="readStudy?id=${study.id }&pageNum=${page.end + 1 }">다음</a></li>
                                </c:if>
                        </ul>
                    </td>
                </tr>
            </tbody>
   </table>
</section>  
<div class="ft"><c:import url="footer.jsp"/></div>
</body>
</html>