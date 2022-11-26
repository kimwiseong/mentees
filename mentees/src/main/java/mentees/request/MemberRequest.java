package mentees.request;

public class MemberRequest {
	private String name;
	private String email;
	private String pw;
	private String pwCheck;
	
	public MemberRequest(String name, String email, String pw, String pwCheck) {
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.pwCheck = pwCheck;
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
	
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getPwCheck() {
		return pwCheck;
	}

	public void setPwCheck(String pwCheck) {
		this.pwCheck = pwCheck;
	}

}
