package mentees.entity;

public class Member {
	private String name;
	private String email;
	private String password;
	private String passwordCheck;
	private String intro;
	
	public Member(String name, String email, String password, String passwordCheck) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
	}
	
	public Member(String name, String email, String intro) {
		this.name = name;
		this.email = email;
		this.intro = intro;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordCheck() {
		return passwordCheck;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}
	
	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}
