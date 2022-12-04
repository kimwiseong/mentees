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

import mentees.entity.StudyComments;

public class StudyCommentsRepository {

	private static Connection con; 
	private static Statement stmt;  
	private static ResultSet rs;
	private static PreparedStatement pstmt;
	
	public StudyCommentsRepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/menteesDB", "root", "0000");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("DB Error in StudyCommentsRepository() : " + e.getMessage());
		}
	}
		
	public boolean insert(StudyComments studyComments) {
		int studyId = studyComments.getStudyId();
		try {
			String findNewIdSql = "select max(id) as maxId, count(*) as newId from studyComments where studyId="+studyId;
			rs = stmt.executeQuery(findNewIdSql);
			
			while(rs.next()) {
				int newId = rs.getInt("maxId")+1;
				if (newId > 0)
					studyComments.setId(newId);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			String sql = "insert into studyComments(id, studyId, name, content) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studyComments.getId());
			pstmt.setInt(2, studyComments.getStudyId());
			pstmt.setString(3, studyComments.getName());
			pstmt.setString(4, studyComments.getContent());
			int isInsert = pstmt.executeUpdate();
			
			if (isInsert > 0) 
				return true;
						
		} catch (Exception e) {
			System.out.println("DB Error in StudyCommentsRepository.insert() : " + e.getMessage());
		}
		return false;	
	}
	
	public List<StudyComments> read(int studyId) {
		String sql = "select * from studyComments where studyId =" + studyId + " order by regDate desc, id desc";
		try {
			List<StudyComments> list = new ArrayList<>();
			rs = stmt.executeQuery(sql);
			System.out.println(rs);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String content = rs.getString("content");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String regDate = sdf.format(rs.getTimestamp("regDate"));
				list.add(new StudyComments(id, studyId, name, content, regDate));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyCommentsRepository.read() : " + e.getMessage());
		}
		
		return null;
	}
	
	public boolean delete(int id, int studyId) {
		String sql = "delete from studyComments where id=" + id + " and studyId=" + studyId;
		try {
			int result = stmt.executeUpdate(sql);
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update studyComments set id=@count:=@count+1 where studyId=" + studyId;
				stmt.executeUpdate(updateSql);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyCommentsRepository.delete() : " + e.getMessage());
		}
		return false;
	}
	
	public boolean update(int id,  int studyId, String content) {
		String sql = "update studyComments set content='"+content+"' where id=" + id + " and studyId=" + studyId;
		try {
			int result = stmt.executeUpdate(sql); 
			if (result > 0) {
				String updateSql = "set @count=0";
				stmt.executeUpdate(updateSql);
				updateSql = "update studyComments set id=@count:=@count+1 where studyId=" + studyId;
				stmt.executeUpdate(updateSql);
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB Error in StudyCommentsRepository.update() : " + e.getMessage());
		}
		return false;
	}
	
}
