package mentees.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mentees.entity.Member;

public class MemberRepository {
	
	private static Connection con; //연결
	private static Statement st; //특정DB에 접근 
	private static ResultSet rs;
	private static PreparedStatement ps;
	
	public MemberRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "root2022");
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB 연동 오류 : " + e.getMessage());
		}
	}
	
	public boolean save(Member member) {
		int result = 0;
		String sql = "INSERT INTO MEMBER(name, email, password) VALUES(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getPassword());
			result = ps.executeUpdate();
			
			
			if (result > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.save() : " + e.getMessage());
		}
		return false;	
	}
	
	public boolean findByEmail(String email) {
		String sql = "SELECT * FROM MEMBER WHERE email = '" + email + "'";
		try {
			rs = st.executeQuery(sql);
			
			if (rs.next()) 
				return true;
						
		} catch (Exception e) {
			System.out.println("데이터베이스 검색 오류 : " + e.getMessage());
		}
		return false;
	}
	
	public static void findByName() {
		
	}
}
