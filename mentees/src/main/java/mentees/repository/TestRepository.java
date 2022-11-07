package mentees.repository;
import java.sql.*;


public class TestRepository {
	
	private Connection con; //연결
	private Statement st; //특정DB에 접근 
	private ResultSet rs;
	
	public TestRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tutorial", "root", "root2022");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("db연동 오류 : " + e.getMessage());
		}
	}
	
	public boolean isAdmin(String adminID, String adminPW) {
		try {
			String sql = "SELECT * FROM ADMIN WHERE adminID = '" + adminID + "' and adminPW = '" + adminPW + "'";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
					
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
		}
		return false;
	}
	
	
	
	

}
