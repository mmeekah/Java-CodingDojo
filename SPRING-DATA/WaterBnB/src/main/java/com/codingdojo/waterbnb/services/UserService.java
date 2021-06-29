package com.codingdojo.waterbnb.services;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codingdojo.waterbnb.models.User;
import com.codingdojo.waterbnb.repositories.RoleRepository;
import com.codingdojo.waterbnb.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private RoleRepository roleRepository;
	
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void saveWithHostRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_HOST"));
		userRepository.save(user);
	}
	
	public void saveWithGuestRole(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName("ROLE_GUEST"));
		userRepository.save(user);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}
}

