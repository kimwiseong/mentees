package mentees.service;

import mentees.repository.LoginRepository;

public class LoginService {
	private static final LoginRepository loginRepository = new LoginRepository();
	
	public boolean findMember(String email, String password) {
		return loginRepository.findMember(email, password);
	}

}
