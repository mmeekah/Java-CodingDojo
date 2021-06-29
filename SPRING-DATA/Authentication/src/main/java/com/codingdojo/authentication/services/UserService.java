package com.codingdojo.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.authentication.models.LoginUser;
import com.codingdojo.authentication.models.User;
import com.codingdojo.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User registerUser(User user)  {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepo.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public User findUserById(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public boolean authenticateUser(LoginUser loginUser) {
		User user = userRepo.findByEmail(loginUser.getEmail());
		if (user == null) {
			return false;
		} else {
			if (BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}

