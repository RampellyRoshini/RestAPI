package org.jsp.spring_boot_user_crud_app.service;

import java.util.List;
import java.util.Optional;
import org.jsp.spring_boot_user_crud_app.dao.UserDao;
import org.jsp.spring_boot_user_crud_app.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao dao;
	
	public User saveUser(User user) {
		return dao.saveUser(user);
		
	}
	
	
	public User updateUser(User user) {
		return dao.saveUser(user);
	}
	
	
	public User findUserById(int id) {
		Optional<User> user = dao.findUserById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			return null;
		}
	}
	
	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}
	
	public List<User> fetchUserByAll(){
		return dao.fetchUserByAll();
	}
	
	public User getUserByEmail(String email) {
		return dao.getUserByEmail(email);
	}
	
	public User login(String email, String password) {
		User user = dao.getUserByEmail(email);
//		if (user.getEmail().equals(password)) {
			if(user.getPassword().equals(password)) {
				return user;
			}else {
				return null;
			}
//		}
	}
	
	public User loginByEmail(User user) {
		User userdb = dao.loginByEmail(user);
		if(userdb != null) {
			return userdb;
		}else {
			return null;
		}
	}

	
}
