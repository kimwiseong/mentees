package mentees.entity;

public class StudyComments {
	private int id;
	private int studyId;
	private String name;
	private String content;
	private String regDate;
	
	public StudyComments(int id, int studyId, String name, String content, String regDate) {
		this.id = id;
		this.studyId = studyId;
		this.name = name;
		this.content = content;
		this.regDate = regDate;
	}
	
	public StudyComments(int studyId, String name, String content) {
		this.studyId = studyId;
		this.name = name;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStudyId() {
		return studyId;
	}
	
	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	
}
