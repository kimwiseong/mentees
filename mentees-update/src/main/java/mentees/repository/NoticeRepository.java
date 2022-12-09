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

import mentees.entity.Notice;

public class NoticeRepository {
	private static Connection con;
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	private static String sql;
	
	public NoticeRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
			
		} catch (Exception e) {
			System.out.println("DB Error in NoticeRepository() : " + e.getMessage());
		}
	}
	
	public List<Notice> readNoticeList() {
		
		sql = "select * from notice order by regDate desc, id desc";
		try {
			List<Notice>  list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Notice(id, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.readNoticeList() : " + e.getMessage());
		}
		
		return null;
	}
	
	
	public List<Notice> readNoticePaging(int amount, int pageNum) {
		
		sql = "select * from notice order by regDate desc, id desc limit " + amount + " offset " + (pageNum-1)*amount;
		try {
			List<Notice>  list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new Notice(id, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.readNoticePaging() : " + e.getMessage());
		}
		
		return null;
	}
	
	public List<Notice> search(String query) {
		
		sql = "select * from notice where title like '%" + query +"%'";
		try {
			List<Notice>  list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				
				list.add(new Notice(id, title, content, name, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.search() : " + e.getMessage());
		}
		
		return null;
	}
	
	public Notice findById(int id) {
		
		sql = "select * from notice where id=" + id;
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				id = Integer.parseInt(rs.getString("id"));
				String title = rs.getString("title");
				String content = rs.getString("content");
				String name = rs.getString("name");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				return new Notice(id, title, content, name, regDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.findById() : " + e.getMessage());
		}
		
		return null;
	}
	
	public boolean insert(Notice notice) {
		try {
			String findNewIdSql = "select max(id) as maxId, count(*) as newId from notice";
			rs = stmt.executeQuery(findNewIdSql);
			
			while(rs.next()) {
				int newId = rs.getInt("maxId")+1;
				if (newId > 0)
					notice.setId(newId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "insert into notice(id, title, content, name) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice.getId());
			pstmt.setString(2, notice.getTitle());
			pstmt.setString(3, notice.getContent());
			pstmt.setString(4, notice.getName());
			int isInsert = pstmt.executeUpdate();
			
			if (isInsert > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in NoticeRepository.insert() : " + e.getMessage());
		}
		return false;	
	}
	
	public boolean deleteById(int id) {
		String sql = "delete from notice where id=" + id;
		//delete from mentorComments where mentorId=1;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update notice set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
				return true;
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.deleteById() : " + e.getMessage());
		}
		return false;
	}
	
	public boolean update(int id, String title, String content) {
		String sql = "update notice set title='"+title+"', content='"+content+"' where id=" + id;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update notice set id=@count:=@count+1";
				stmt.executeUpdate(updateSql);
				return true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.update() : " + e.getMessage());
		}
		return false;
	}
	
	public int total() {
		String sql = "select count(*) as total from notice";
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) 
				return rs.getInt("total");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in NoticeRepository.total() : " + e.getMessage());
		}
		return 0;
	}
	
	
}
