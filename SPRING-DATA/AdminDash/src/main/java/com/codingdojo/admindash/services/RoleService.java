package com.codingdojo.admindash.services;


import org.springframework.stereotype.Service;

import com.codingdojo.admindash.models.Role;
import com.codingdojo.admindash.repositories.RoleRepository;

@Service
public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository)     {
        this.roleRepository = roleRepository;
    }
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }
}
