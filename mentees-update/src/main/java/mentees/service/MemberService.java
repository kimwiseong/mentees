package mentees.service;

import mentees.entity.Member;
import mentees.repository.MemberRepository;

public class MemberService {
	
	private static final MemberRepository memberRepository = new MemberRepository();
	
	public String save(Member member) {
		String name = member.getName();
		String email = member.getEmail();
		String password = member.getPassword();
		String passwordCheck = member.getPasswordCheck();
		
		if (password.length() < 6) 
			return "비밀번호를 6자리 이상 입력해주세요";
		if (isValidEmail(email)) 
			return "이메일에 공백을 입력하였습니다.";
		if (findByEmail(email) != null)
			return "이미 등록된 이메일입니다.";
		if (findByName(name) != null)
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
	
	public static boolean isEqualPassword(String password, String passwordCheck) {
		return password.equals(passwordCheck);
	}
	
	public static boolean isValidPassword(String password) {
		return password.equals("") || password.equals(null);
	}
	
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}
	
	public Member findByName(String name) {
		return memberRepository.findByName(name);
	}
	
	public String findMemberNameByEmail(String email) {
		return memberRepository.findMemberNameByEmail(email);
	}
	
	public boolean update(String email, String intro) {
		return memberRepository.update(email, intro);
	}
	
	public boolean updateImage(String email, String image) {
		return memberRepository.updateImage(email, image);
	}

}
