<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/menteesdb?serverTimezone=UTC";
		conn = DriverManager.getConnection(url, "root", "0000");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery("select * from mentor order by id desc");
	} catch (Exception e) {
		out.println("DB 연동 오류입니다.:" + e.getMessage());
	}
	while (rs.next()) {
		String title = rs.getString("title");
	%>
	<a href="<c:url value='mentrecruit'/>" ><%=title%><br></a>
	<%
	}
	rs.close();
	stmt.close();
	conn.close();
	%>
</body>
</html>