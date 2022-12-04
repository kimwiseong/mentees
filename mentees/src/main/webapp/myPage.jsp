<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>myPage</title>
  <link rel="stylesheet" href="css/nav.css">
  <link rel="stylesheet" href="css/myPage.css">

</head>
<body>
     <c:import url="header.jsp"></c:import>
  
    <img src="img/1.PNG" class="userImage" width="20%">
    <div class="userInfo">
      <table>
         <tr>
            <td> 이름 : ${ member.name }</td>
        </tr>
        <tr>
            <td> 이메일 : ${ member.email }</td>
        </tr>
      </table><br>
    </div>
    
    <div class="changeProfile">
       <form method="post" enctype="multipart/form-data">    
            <label for="chooseFile">👉 프로필 변경 👈</label>      
            <input type="file" id="chooseFile" name="chooseFile" accept="image/*" onchange="loadFile(this)">
       </form>
    </div>
    
    <div class="moreInfo">
         <table class="intro">
            <tr>
               <td>${ member.intro }</td>
           </tr>
            </table>           
    </div>
    
    <form action="myPageModify.jsp" method="post">
    <div class="area">
    	<input type="hidden" name="myIntro" value="${member.intro }">
      <input type="submit" value="내정보 수정" class="modifyButton" />
    </div>
    </form>
</body>
</html>