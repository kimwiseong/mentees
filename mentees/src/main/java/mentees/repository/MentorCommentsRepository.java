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

import mentees.entity.MentorComments;

public class MentorCommentsRepository {

	private static Connection con; 
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public MentorCommentsRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB Error in MentorCommentsRepository() : " + e.getMessage());
		}
	}
		
	public boolean insert(MentorComments mentorComments) {
		int mentorId = mentorComments.getMentorId();
		try {
			String findNewIdSql = "select max(id) as maxId, count(*) as newId from mentorComments where mentorId="+mentorId;
			rs = stmt.executeQuery(findNewIdSql);
			
			while(rs.next()) {
				int newId = rs.getInt("maxId")+1;
				if (newId > 0)
					mentorComments.setId(newId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "insert into mentorComments(id, mentorId, name, content) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, mentorComments.getId());
			pstmt.setInt(2, mentorComments.getMentorId());
			pstmt.setString(3, mentorComments.getName());
			pstmt.setString(4, mentorComments.getContent());
			int isInsert = pstmt.executeUpdate();
			
			if (isInsert > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in MentorCommentsRepository.insert() : " + e.getMessage());
		}
		return false;	
	}
	
	public List<MentorComments> read(int mentorId) {
		String sql = "select * from mentorComments where mentorId =" + mentorId+ " order by regDate desc, id desc";
		try {
			List<MentorComments> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = rs.getInt("id");
//				mentorId = rs.getInt("mentorId");
				String name = rs.getString("name");
				String content = rs.getString("content");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new MentorComments(id, mentorId, name, content, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorCommentsRepository.read() : " + e.getMessage());
		}
		return null;
	}
	
	public List<MentorComments> readPaging(int mentorId, int amount, int pageNum) {
		String sql = "select * from mentorComments where mentorId =" + mentorId+ " order by regDate desc, id desc limit " + amount + " offset " + (pageNum-1)*amount;;
		try {
			List<MentorComments> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new MentorComments(id, mentorId, name, content, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorCommentsRepository.readPaging() : " + e.getMessage());
		}
		return null;
	}
	
	
	public boolean delete(int id, int mentorId) {
		String sql = "delete from mentorComments where id=" + id + " and mentorId=" + mentorId;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update mentorComments set id=@count:=@count+1 where mentorId=" + mentorId;
				stmt.executeUpdate(updateSql);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorCommentsRepository.delete() : " + e.getMessage());
		}
		return false;
	}
	
	public boolean update(int id,  int mentorId, String content) {
		String sql = "update mentorComments set content='"+content+"' where id=" + id + " and mentorId=" + mentorId;
		try {
			int result = stmt.executeUpdate(sql); 
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update mentorComments set id=@count:=@count+1 where mentorId=" + mentorId;
				stmt.executeUpdate(updateSql);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorCommentsRepository.update() : " + e.getMessage());
		}
		return false;
	}
	
	public int total(int mentorId) {
		String sql = "select count(*) as total from mentorComments where mentorId=" + mentorId;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) 
				return rs.getInt("total");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in MentorCommentsRepository.total() : " + e.getMessage());
		}
		return 0;
	}
	
}
