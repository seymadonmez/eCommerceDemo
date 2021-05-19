package eCommerceDemo;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.business.concretes.UserManager;
import eCommerceDemo.core.abstracts.AuthService;
import eCommerceDemo.core.concretes.AuthManager;
import eCommerceDemo.core.concretes.EmailVerificationManager;
import eCommerceDemo.core.concretes.UserValidationManager;
import eCommerceDemo.dataAccess.concretes.HibernateUserDao;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao());

		AuthService authService = new AuthManager(userService,new EmailVerificationManager(),new UserValidationManager());
		authService.register(1, "Þeyma", "Dönmez", "seymadonmezz1@gmail.com", "123456"); 
	}

}
