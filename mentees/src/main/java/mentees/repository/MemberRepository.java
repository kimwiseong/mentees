package mentees.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import mentees.entity.Member;

public class MemberRepository {
	
	private static Connection con; 
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public MemberRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository() : " + e.getMessage());
		}
	}
	
	public boolean save(Member member) {
		int result = 0;
		String sql = "insert into member(name, email, password) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPassword());
			result = pstmt.executeUpdate();
			
			if (result > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.save() : " + e.getMessage());
		}
		return false;
	}
	
	public Member findByEmail(String email) {
		String sql = "select * from member where email = '" + email + "'";
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Member member = new Member();
				String name = rs.getString("name");
				String intro = rs.getString("intro");
				String image = rs.getString("image");
				
				member.setName(name);
				member.setEmail(email);
				member.setIntro(intro);
				member.setImage(image);

				return member;
			}
						
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.findByEmail() : " + e.getMessage());
		}
		return null;
	}
	
	public Member findByName(String name) {
		String sql = "select * from member where name = '" + name + "'";
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Member member = new Member();
				String email = rs.getString("email");
				String intro = rs.getString("intro");
				String image = rs.getString("image");
				
				member.setName(name);
				member.setEmail(email);
				member.setIntro(intro);
				member.setImage(image);

				return member;
			}
						
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.findByName() : " + e.getMessage());
		}
		return null;
	}
	
	public String findMemberNameByEmail(String email) {
		String sql = "select name from member where email = '" + email + "'";
		try {
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) 
				return rs.getString("name");
						
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.findMemberNameByEmail() : " + e.getMessage());
		}
		return null;
	}
	
	//마이페이지 정보 업데이트 
	public boolean update(String email, String intro) {
		String sql = "update member set intro = '" + intro + "' where email='"+email+"'";
		try {
			int result = stmt.executeUpdate(sql);
			
			if (result > 0) 
				return true;
			
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.update() " + e.getMessage());
		}
		return false;
	}
	
	public boolean updateImage(String email, String image) {
		String sql = "update member set image='" + image + "' WHERE email='" + email + "'";
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) 
				return true;
			
		} catch (Exception e) {
			System.out.println("DB Error in MemberRepository.update() " + e.getMessage());
		}
		return false;
	}
	
}
