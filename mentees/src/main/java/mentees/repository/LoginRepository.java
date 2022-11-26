package mentees.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginRepository {
	private static Connection con; //연결
	private static Statement st; //특정DB에 접근 
	private static ResultSet rs;
	private static PreparedStatement ps;
	
	public LoginRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "root2022");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		}
	}
	
	public boolean findMember(String email, String password) {
		String sql = "SELECT * FROM MEMBER WHERE email = '" + email + "' AND password = '" + password + "'";
		try {
			rs = st.executeQuery(sql);
			if (rs.next()) 
				return true;
						
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
		}
		return false;
	}
	
	
}
