package com.codingdojo.admindash.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.admindash.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);

	Optional<User> findById(Long id);
	void delete(Long id);
	void save(Optional<User> user);
}