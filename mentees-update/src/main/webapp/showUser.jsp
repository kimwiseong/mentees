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
     <img src="img/${member.image}" onerror="this.onerror=null; this.src='img/기본 프로필 이미지.jpg';" class="userImage" id="target_img"/>  
     <div class="userInfo">
     <table>
         <tr>
            <td> 이름 : ${ member.name }</td>
         </tr>
         <tr>
            <td> 이메일 : ${ member.email }</td>
         </tr>
     </table>
     <br>
     </div>
     <div class="moreInfo">
         <table class="intro">
            <tr>
               <td>${ member.intro }</td>
           </tr>
         </table>           
    </div>
    <c:import url="footer.jsp"/>
</body>
</html>