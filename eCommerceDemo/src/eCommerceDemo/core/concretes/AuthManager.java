package eCommerceDemo.core.concretes;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.core.abstracts.AuthService;
import eCommerceDemo.core.abstracts.UserValidationService;
import eCommerceDemo.core.abstracts.VerificationService;
import eCommerceDemo.entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	VerificationService verificationService;


	public AuthManager() {

	}

	public AuthManager(UserService userService,VerificationService verificationService,UserValidationService userValidationService) {
		super();
		this.userService = userService;
		this.verificationService=verificationService;
		this.userValidationService=userValidationService;

	}
	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {

		User userToRegister = new User(id, firstName, lastName, email, password);
		if(!this.userValidationService.registerValidator(userToRegister))
		{
			System.out.println("Kullanýcý bilgilerinizi kontrol ediniz!");
		}
		
		if(!checkIfUserExists(email))
		{
			System.out.println("Bu e-mail adresi ile kayýt mevcut. Lütfen baþka bir mail adresi giriniz.");
			return;
		}
		if (!this.verificationService.verificate(userToRegister)) {
			System.out.println("Üyelik doðrulama iþlemi tamamlanmadýðý için kayýt yapýlamadý!");
		}

		userService.add(userToRegister);
		
	}

	@Override
	public void login(String email, String password) {
		if(!this.userValidationService.loginValidator(email, password))
		{
			System.out.println("Giriþ bilgilerinizi kontrol ediniz!");
			return;
		}
		User userToLogin=userService.getByEmailAndPassword(email, password);
		
		if (userToLogin == null) {
			System.out.println("E-posta veya þifrenizi kontrol ediniz!");
			return;
		}
		if(!checkIfUserVerified(userToLogin)) 
		{
			System.out.println("Üyelik doðrulama iþlemi tamamlanmadýðý için giriþ yapýlamadý!");
			return;
		}
		System.out.println("Giriþ baþarýlý! Hoþgeldiniz, " + userToLogin.getFirstName() + " " + userToLogin.getLastName());
	}
	
	private boolean checkIfUserExists(String email)
	{
		return userService.getByMail(email)==null;
	}
	
	private boolean checkIfUserVerified(User user)
	{
		return verificationService.verificate(user);
	}

}
