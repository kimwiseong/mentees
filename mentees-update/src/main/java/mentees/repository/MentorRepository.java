package mentees.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import mentees.entity.Mentor;

public class MentorRepository {
	private static Connection con; 
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public MentorRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
			
		} catch (Exception e) {
			System.out.println("DB Error in MentorRepository() : " + e.getMessage());
		}
	}
	
	public boolean insert(Mentor mentor) {
		try {
			String findNewIdSql = "select max(id) as maxId, count(*) as newId from mentor";
			rs = stmt.executeQuery(findNewIdSql);
			
			while(rs.next()) {
				int newId = rs.getInt("maxId")+1;
				if (newId > 0)
					mentor.setId(newId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "insert into mentor(id, subject, title, content, name) VALUES(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mentor.getId());
			pstmt.setString(2, mentor.getSubject());
			pstmt.setString(3, mentor.getTitle());
			pstmt.setString(4, mentor.getContent());
			pstmt.setString(5, mentor.getName());
			int isInsert = pstmt.executeUpdate();
			
			if (isInsert > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in MentorRepository.insert() : " + e.getMessage());
		}
		return false;	
	}
	
	
	public List<Mentor> readMentorList() {
		
		String sql = "select * from mentor order by regDate desc, id desc";
		try {
			List<Mentor> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String subject = rs.getString("subject");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Mentor(id, subject, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.readMentorList() : " + e.getMessage());
		}
		
		return null;
	}
	
	
	public List<Mentor> readMentorPaging(int amount, int pageNum) {
		
		String sql = "select * from mentor order by regDate desc, id desc limit " + amount + " offset " + (pageNum-1)*amount;
		try {
			List<Mentor> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String subject = rs.getString("subject");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Mentor(id, subject, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.readMentorPaging() : " + e.getMessage());
		}
		
		return null;
	}
	
	
	
	public List<Mentor> searchBySubject(String query) { 
		String sql = "select * from mentor where subject like '%" + query +"%'";
		try {
			List<Mentor> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String subject = rs.getString("subject");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Mentor(id, subject, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.searchBySubject() : " + e.getMessage());
		}
		
		return null;
	}
	
	public Mentor findById(int id) {
		String sql = "select * from mentor where id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = Integer.parseInt(rs.getString("id"));
				String subject = rs.getString("subject");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				return new Mentor(id, subject, title, content, name, regDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.findById() : " + e.getMessage());
		}
		
		return null;
	}
	
	public String findNameById(int id) {
		String sql = "select name from mentor where id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				return rs.getString("name");
			}
			
		} catch (SQLException e) {
			System.out.println("DB Error in MentorRepository.findNameById() : " + e.getMessage());
		}
		return null;
	}
	
	
	public boolean deleteById(int id) {
		String sql = "delete from mentor where id=" + id;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update mentor set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
			}
			sql = "delete from mentorComments where mentorId=" + id;
			result = stmt.executeUpdate(sql);
			if(result > 0) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.deleteById() : " + e.getMessage());
		}
		return false;
	}
	
	public boolean update(int id,  String title, String subject, String content) {
		String sql = "update mentor set title='"+title+"', subject='"+subject+"', content='"+content+"' where id=" + id;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update mentor set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println("DB Error in MentorRepository.update() : " + e.getMessage());
		}
		return false;
	}
	
	public int total() {
		String sql = "select count(*) as total from mentor";
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) 
				return rs.getInt("total");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorRepository.total() : " + e.getMessage());
		}
		return 0;
	}
	
}
