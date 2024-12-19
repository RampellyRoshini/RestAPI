package org.jsp.spring_boot_user_crud_app.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.spring_boot_user_crud_app.dto.User;
import org.jsp.spring_boot_user_crud_app.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private UserRespository respository;
	
//	------ save-----------
	public User saveUser(User user) {
		return respository.save(user);		
	}
	
//	------------- Update-----------
	public User updateUser(User user) {
		return respository.save(user);
	}
	
//	-----------find--------------
	public Optional<User> findUserById(int id) {
		return respository.findById(id);
	}
//	----------- Delete------------
	public void deleteUserById(int id){
		respository.deleteById(id);
	}
//	------------------findAll--------------
	public List<User> fetchUserByAll() {
		return respository.findAll();
	}
//	-------------find email----------------
	public User getUserByEmail(String email) {
		return respository.getByEmail(email);
	}
//	--------------finding by mail---------------------
	public User login(String email) {
		return respository.getByEmail(email);
	}
	
	public User loginByEmail(User user) {
		return respository.login(user.getEmail(), user.getPassword());
	}
	
}
