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

import mentees.entity.Study;

public class StudyRepository {
	private static Connection con; 
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public StudyRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
			
		} catch (Exception e) {
			System.out.println("DB Error in StudyRepository() : " + e.getMessage());
		}
	}
	
	public boolean insert(Study study) {
		try {
			String findNewIdSql = "select max(id) as maxId, count(*) as newId from study";
			rs = stmt.executeQuery(findNewIdSql);
			
			while(rs.next()) {
				int newId = rs.getInt("maxId")+1;
				if (newId > 0)
					study.setId(newId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "insert into study(id, title, content, name) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, study.getId());
			pstmt.setString(2, study.getTitle());
			pstmt.setString(3, study.getContent());
			pstmt.setString(4, study.getName());
			int isInsert = pstmt.executeUpdate();
			
			if (isInsert > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in StudyRepository.insert() : " + e.getMessage());
		}
		return false;	
	}
	
	public List<Study> readStudyList() {
		
		String sql = "select * from study order by regDate desc, id desc";
		try {
			List<Study>  list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Study(id, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("DB Error in StudyRepository.readStudyList() : " + e.getMessage());
		}
		
		return null;
	}
	
	
	public List<Study> search(String query) {
		
		String sql = "select * from study where title like '%" + query +"%'";
		
		try {
			List<Study>  list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				
				list.add(new Study(id, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyRepository.search() : " + e.getMessage());
		}
		
		return null;
	}
	
	
	public Study findById(int id) {
		
		String sql = "select * from study where id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				return new Study(id, title, content, name, regDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyRepository.findById() : " + e.getMessage());
		}
		
		return null;
	}
	
	public String findNameById(int id) {
		String sql = "select name from study where id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				return rs.getString("name");
			}
			
		} catch (SQLException e) {
			System.out.println("DB Error in StudyRepository.findNameById() : " + e.getMessage());
		}
		return null;
	}
	
	public boolean deleteById(int id) {
		String sql = "delete from study where id=" + id;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update study set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyRepository.deleteById() : " + e.getMessage());
		}
		return false;
	}
	
	public boolean update(int id, String title, String content) {
		String sql = "update study set title='"+title+"', content='"+content+"' where id=" + id;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update study set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyRepository.update() : " + e.getMessage());
		}
		return false;
	}
	
	
}
