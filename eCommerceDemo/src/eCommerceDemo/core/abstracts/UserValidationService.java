package eCommerceDemo.core.abstracts;

import eCommerceDemo.entities.concretes.User;

public interface UserValidationService {
	boolean registerValidator(User user);
	boolean loginValidator(String email, String password);
}
