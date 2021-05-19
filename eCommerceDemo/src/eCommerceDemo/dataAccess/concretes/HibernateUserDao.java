package eCommerceDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceDemo.dataAccess.abstracts.UserDao;
import eCommerceDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibernate ile kullanýcý eklendi : " + user.getFirstName() +" "+ user.getLastName());
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for (User user : users) {
			if (user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}

	@Override
	public void update(User user) {
		User userToUpdate = getById(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		
	}

	@Override
	public void delete(User user) {
		users.removeIf(u->u.getId()==user.getId());
		
	}

	@Override
	public User getById(int id) {
		for (User user : users) {
			if (user.getId()==id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByMail(String email) {
		for (User user : users) {
			if (user.getEmail()==email) {
				return user;
			}
		}
		return null;
	}

	

}
