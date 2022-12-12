package mentees.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginRepository {
	private static Connection con;
	private static Statement stmt;  
	private static ResultSet rs;
	
	
	public LoginRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB Error in LoginRepository() : " + e.getMessage());
		}
	}
	
	public boolean findMember(String email, String password) {
		String sql = "select * from member where email = '" + email + "' and password = '" + password + "'";
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in LoginRepository.findMember()() : " + e.getMessage());
		}
		return false;
	}
	
	
}
