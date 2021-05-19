package eCommerceDemo.core.concretes;

import java.util.regex.Pattern;

import eCommerceDemo.core.abstracts.UserValidationService;
import eCommerceDemo.entities.concretes.User;

public class UserValidationManager implements UserValidationService{

	public UserValidationManager() {
		
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	@Override
	public boolean registerValidator(User user) {
		boolean result=checkIfFirstNameIsValid(user.getFirstName())&& checkIfLastNameIsValid(user.getLastName())&&checkIfEmailIsValid(user.getEmail())&&checkIfFieldsEntered(user);
		return result;
	}

	@Override
	public boolean loginValidator(String email, String password) {
		boolean result=checkIfEmailIsValid(email)&&checkIfPasswordIsValid(password);
		return result;
	}
	
	private boolean checkIfFirstNameIsValid(String firstName) {
		if (firstName.length()>2) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfLastNameIsValid(String lastName) {
		if (lastName.length()>2) {
			return true;
		}
		return false;
	}
	
	private boolean checkIfEmailIsValid(String email) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}
	
	private boolean checkIfPasswordIsValid(String password) {
		if (password.length()>6) {
			return true;
		}
		return false;
	}
	
	public boolean checkIfFieldsEntered(User user) {
		if (user.getFirstName().length()<=0 || user.getLastName().length()<=0 ||user.getPassword().length()<=0|| user.getEmail().length()<=0) {
			return false;
		}
		return true;
	}
	
}
