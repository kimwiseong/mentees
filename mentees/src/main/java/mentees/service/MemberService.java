package mentees.service;

import mentees.entity.Member;
import mentees.repository.MemberRepository;

public class MemberService {
	
	private static MemberRepository memberRepository = new MemberRepository();
	
	public String save(Member member) {
		String email = member.getEmail();
		String password = member.getPassword();
		String passwordCheck = member.getPasswordCheck();
		
		if (isValidEmail(email)) 
			return "이메일에 공백을 입력하였습니다.";
		if (isDuplicatedEmail(email))
			return "이미 등록된 이메일입니다.";
		if (!isEqualPassword(password, passwordCheck))
			return "비밀번호가 일치하지 않습니다.";
		if (isValidPassword(password))
			return "비밀번호에 공백을 입력하였습니다.";
		
		if(memberRepository.save(member))
			return "회원가입에 성공하였습니다.";
		
		return "회원가입에 실패했습니다.";
	}
	
	public static boolean isValidEmail(String email) {
		return email.equals("") || email.equals(null);
	}
	
	public static boolean isDuplicatedEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	
	public static boolean isEqualPassword(String password, String passwordCheck) {
		return password.equals(passwordCheck);
	}
	
	public static boolean isValidPassword(String password) {
		return password.equals("") || password.equals(null);
	}

}
