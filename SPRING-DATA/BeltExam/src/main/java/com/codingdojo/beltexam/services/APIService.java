package com.codingdojo.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.beltexam.models.Event;

import com.codingdojo.beltexam.models.User;
import com.codingdojo.beltexam.repositories.EventRepository;

import com.codingdojo.beltexam.repositories.UsersEventsRepository;
import com.codingdojo.beltexam.repositories.UserRepository;

@Service
public class APIService {
	private final UserRepository userRepo;
	private final EventRepository eventRepo;
	private final UsersEventsRepository userEventRepo;

	
	public APIService(UserRepository userRepo, EventRepository eventRepo, UsersEventsRepository userEventRepo) {
		this.userRepo = userRepo;
		this.eventRepo = eventRepo;
		this.userEventRepo = userEventRepo;
		
	}
	
	public void deleteEvent(Long id) {
		eventRepo.deleteById(id);
	}
	
    public List<Event> allEvents() {
    	return (List<Event>) eventRepo.findAll();
    }
	
	public Event addEvent(Event event) {
		return eventRepo.save(event);
	}
	

	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public Event findEventById(Long id) {
    	Optional<Event> e = eventRepo.findById(id);
    	if(e.isPresent()) {
            return e.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public void updateEvent(Event event) {
        eventRepo.save(event);
    }
    
    public void updateUser(User user) {
        userRepo.save(user);
    }
    

    
    //Authentication
    public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public boolean duplicateUser(String email) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
}
