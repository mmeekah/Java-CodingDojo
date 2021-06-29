package com.codingdojo.selfjoins.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.selfjoins.models.User;
import com.codingdojo.selfjoins.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}
	
	public User findOneUser(Long id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public void addFriend(Long userId, Long friendId) {
		Optional<User> u = userRepo.findById(userId);
		Optional<User> f = userRepo.findById(friendId);
		if (u.isPresent() && f.isPresent()) {
			List<User> uFriends = u.get().getFriends();
			if (!uFriends.contains(f)) {
				uFriends.add(f.get());
				u.get().setFriends(uFriends);
				userRepo.save(u.get());
			}
			List<User> fFriends = f.get().getFriends();
			if (!fFriends.contains(u)) {
				fFriends.add(u.get());
				f.get().setFriends(fFriends);
				userRepo.save(f.get());
			}
		}
	}
	
	public void dropFriend(Long userId, Long friendId) {
		Optional<User> u = userRepo.findById(userId);
		Optional<User> f = userRepo.findById(friendId);
		if (u.isPresent() && f.isPresent()) {
			List<User> uFriends = u.get().getFriends();
			uFriends.remove(f.get());
			u.get().setFriends(uFriends);
			userRepo.save(u.get());
			List<User> fFriends = f.get().getFriends();
			fFriends.remove(u.get());
			f.get().setFriends(fFriends);
			userRepo.save(f.get());
		}
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}	
}