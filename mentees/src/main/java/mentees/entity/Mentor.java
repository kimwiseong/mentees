package mentees.entity;

public class Mentor {
	
	private int id;
	private String subject;
	private String title;
	private String content;
	private String name;
	private String regDate;
	
	public Mentor () {
		
	}
	
	public Mentor (String subject, String title, String content, String name) {
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.name = name;
	}
	
	public Mentor (int id, String subject, String title, String content, String name) {
		this.id = id;
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.name = name;
	}
	
	public Mentor (int id, String subject, String title, String content, String name, String regDate) {
		this.id = id;
		this.subject = subject;
		this.title = title;
		this.content = content;
		this.name = name;
		this.regDate = regDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
