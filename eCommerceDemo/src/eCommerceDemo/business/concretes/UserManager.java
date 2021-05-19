package eCommerceDemo.business.concretes;

import java.util.List;

import eCommerceDemo.business.abstracts.UserService;
import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class UserManager implements UserService {

	UserDao userdao;
	public UserManager(UserDao userdao) {
		this.userdao=userdao;
	}
	
	@Override
	public void add(User user) {
		userdao.add(user);
		System.out.println("Kullanýcý baþarýlý olarak eklendi.");
		
	}

	@Override
	public void update(User user) {
		userdao.update(user);
		System.out.println("Kullanýcý güncellendi.");
	}

	@Override
	public void delete(User user) {
		userdao.delete(user);
		System.out.println("Kullanýcý silindi");
		
	}

	@Override
	public User getById(int id) {
		
		return userdao.getById(id);
	}

	@Override
	public User getByMail(String email) {
	
		return userdao.getByMail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		
		return userdao.getByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getAll() {
		
		return userdao.getAll();
	}

}
