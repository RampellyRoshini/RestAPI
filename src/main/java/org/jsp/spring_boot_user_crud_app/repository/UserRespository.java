package org.jsp.spring_boot_user_crud_app.repository;


import org.jsp.spring_boot_user_crud_app.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRespository extends JpaRepository<User, Integer>{
	public User getByEmail(String email);
	
	@Query("Select u from User u where u.email=?1 And u.password=?2")
	public User login(String email, String password);
}
