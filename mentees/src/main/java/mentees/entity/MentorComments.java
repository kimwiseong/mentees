package mentees.entity;

public class MentorComments {
	private int id;
	private int mentorId;
	private String name;
	private String content;
	private String regDate;
	
	public MentorComments(int id, int mentorId, String name, String content, String regDate) {
		this.id = id;
		this.mentorId = mentorId;
		this.name = name;
		this.content = content;
		this.regDate = regDate;
	}
	
	public MentorComments(int mentorId, String name, String content) {
		this.mentorId = mentorId;
		this.name = name;
		this.content = content;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMentorId() {
		return mentorId;
	}
	
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
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
