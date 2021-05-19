package eCommerceDemo.core.concretes;

import eCommerceDemo.core.abstracts.AuthService;
import eCommerceDemo.googleAuthenticator.GoogleAuthenticatorManager;

public class GoogleAuthenticationManagerAdapter implements AuthService {

	GoogleAuthenticatorManager manager=new GoogleAuthenticatorManager();

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		manager.register(id,firstName,lastName,email,password);
		System.out.println("Google hesab� ile kay�t olundu : " + email);
	}

	@Override
	public void login(String email, String password) {
		manager.login(email, password);
		System.out.println("Google hesab� ile giri� yap�ld� : " + email);
	}

	
	
	
	
}
