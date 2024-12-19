package org.jsp.spring_boot_user_crud_app.controller;

import java.util.List;
import org.jsp.spring_boot_user_crud_app.dto.User;
import org.jsp.spring_boot_user_crud_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
//	@GetMapping("finduser/id")
//	public User findUserById(@RequestParam int id) {
//		return service.findUserById(id);
//	}
//	---------------- or---------------------
	
	@GetMapping("finduser/{id}")
	public User findUserById(@PathVariable int id) {
		return service.findUserById(id);
	}
	
	@DeleteMapping("deleteuser/{id}")
	public void deleteUserById(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
	@GetMapping("/findall")
	public List<User> fetchUserByAll(){
		return service.fetchUserByAll();
	}
	
	@GetMapping("getbyemail/{email}")
	public User emailUser(@PathVariable String email) {
		return service.getUserByEmail(email);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return service.login(user.getEmail(), user.getPassword());
	}
	@PostMapping("/loginbyemail")
	public User loginByEmail(@RequestBody User user) {
		return service.loginByEmail(user);
	}

}
