package com.codingdojo.admindash.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.admindash.validators.UserValidator;
import com.codingdojo.admindash.models.User;
import com.codingdojo.admindash.services.RoleService;
import com.codingdojo.admindash.services.UserService;

@Controller
public class UserController {
	private UserService userService;
	private RoleService roleService;
	private UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator, RoleService roleService) {
    		this.userService = userService;
    		this.userValidator = userValidator;
    		this.roleService = roleService;
    }
	
	@RequestMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
        return "loginReg.jsp";
    }
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "loginReg.jsp";
		}
		 else if(roleService.findByName("ROLE_SUPERADMIN").getUsers().size() < 1) {
			userService.saveUserWithSuperAdminRole(user);
		}
		else {
			userService.saveWithUserRole(user);
		}
		session.setAttribute("created", "Account created. Please log in.");
		return "redirect:/login";
    }
	
	@RequestMapping("/loggedin")
	public String updatedLoggedIn(Principal principal, HttpSession session) {
		session.removeAttribute("created");
		String email = principal.getName();
		User user = userService.findByEmail(email);
        userService.updateLoggedIn(user);
        if(user.checkIfAdmin()) {
        		return "redirect:/admin";
        }
        else {
        		return "redirect:/dashboard";
        }
	}
	
	@RequestMapping("/dashboard")
    public String home(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        return "home.jsp";
    }
	@RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(email));
        model.addAttribute("users", userService.getAllUsers());
        return "adminPage.jsp";
    }
	@RequestMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
	@RequestMapping("/users/admin/{id}")
	public String makeUserAdmin(@PathVariable("id") Long id) {
		userService.makeAdmin(id);
		return "redirect:/admin";
	}
}
