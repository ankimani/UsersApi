package com.albert.userapi.UserController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albert.userapi.User.User;
import com.albert.userapi.exception.ResourceNotFoundException;
import com.albert.userapi.userRepository.userRepository;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	private userRepository UserRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return UserRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId) throws ResourceNotFoundException {
		User user = UserRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("user with Id" + "::" + UserId + "Not Found"));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return UserRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long UserId,
			@Valid @RequestBody User userDetails) throws ResourceNotFoundException {
		User user = UserRepository.findById(UserId)
				.orElseThrow(() -> new ResourceNotFoundException("User with id::" + UserId + "Not Found"));
		user.setEmail(userDetails.getEmail());
		user.setFisrtName(userDetails.getFisrtName());
		user.setLastName(userDetails.getLastName());
		user.setUpdatedAt(new Date());
		final User updatedUser = UserRepository.save(user);
		return ResponseEntity.ok(updatedUser);

	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable (value="id")Long UserId)throws Exception{
		User user=UserRepository.findById(UserId).orElseThrow(()->new ResourceNotFoundException("User with id::"+UserId+"Not found"));
	UserRepository.delete(user);
	 Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	return response;
	}
}
