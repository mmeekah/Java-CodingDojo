package com.codingdojo.studentroster.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.studentroster.models.Contact;
import com.codingdojo.studentroster.models.Course;
import com.codingdojo.studentroster.models.Dormitory;
import com.codingdojo.studentroster.models.Student;
import com.codingdojo.studentroster.services.APIService;

@Controller
public class HomeController {
	private APIService api;
	
	public HomeController(APIService api) {
		this.api = api;
	}
	
	// Index Resources
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/students/pages/{pageNumber}")
	public String studentIndex(@PathVariable("pageNumber") int pageNumber, Model model) {
		Page<Student> students = api.studentsPerPage(pageNumber - 1);
		int totalPages = students.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("students", students);
		model.addAttribute("pageNumber", pageNumber);
		return "/students/index.jsp";
	}
	
	@RequestMapping("/dorms")
	public String dormIndex(Model model) {
		List<Dormitory> dorms = api.findAllDorms();
		model.addAttribute("dorms", dorms);
		return "/dorms/index.jsp";
	}
	
	@RequestMapping("/classes")
	public String classIndex(Model model) {
		List<Course> courses = api.findAllCourses();
		model.addAttribute("courses", courses);
		return "/classes/index.jsp";
	}
	
	// New Resource Forms
	@RequestMapping("/students/new")
	public String newStudent(@ModelAttribute("student") Student student) {
		return "/students/new.jsp";
	}
	
	@RequestMapping("/contacts/new")
	public String newContact(@ModelAttribute("contact") Contact contact, Model model) {
		List<Student> students = api.findByContactNull();
		model.addAttribute("students", students);
		return "/contacts/new.jsp";
	}
	
	@RequestMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dormitory dorm) {
		return "/dorms/new.jsp";
	}
	
	@RequestMapping("/classes/new")
	public String newClass(@ModelAttribute("course") Course course) {
		return "/classes/new.jsp";
	}
	
	// POST Methods - Create Resources
	@RequestMapping(value="/students", method=RequestMethod.POST)
	public String createStudent(
			@Valid @ModelAttribute("student") Student student,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/students/new.jsp";
		} else {
			api.createStudent(student);
			return "redirect:/students/pages/1";
		}
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public String createContact(
			@Valid @ModelAttribute("contact") Contact contact,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<Student> students = api.findByContactNull();
			model.addAttribute("students", students); 
			return "/contacts/new.jsp";
		} else {
			api.createContact(contact);
			return "redirect:/students/pages/1";
		}
	}
	
	@RequestMapping(value="/dorms", method=RequestMethod.POST)
	public String createDorm(
			@Valid @ModelAttribute("dorm") Dormitory dorm,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/dorms/new.jsp";
		} else {
			api.createDorm(dorm);
			return "redirect:/dorms";
		}
	}
	
	@RequestMapping(value="/classes", method=RequestMethod.POST)
	public String createClass(
			@Valid @ModelAttribute("course") Course course,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/classes/new.jsp";
		} else {
			api.createCourse(course);
			return "redirect:/classes";
		}
	}
	
	// Show Resources
	@RequestMapping("/students/{id}")
	public String showStudent(@PathVariable("id") Long id, Model model) {
		Student student = api.findOneStudent(id);
		List<Course> courses = api.findCoursesNotEnrolled(id);
		model.addAttribute("student", student);
		model.addAttribute("courses", courses);
		return "/students/show.jsp";
	}
	
	@RequestMapping("/dorms/{id}")
	public String showDorm(@PathVariable("id") Long id, Model model) {
		Dormitory dorm = api.findOneDorm(id);
		List<Student> students = api.findByDormNull();
		model.addAttribute("dorm", dorm);
		model.addAttribute("students", students);
		return "/dorms/show.jsp";
	}
	
	@RequestMapping("/classes/{id}")
	public String showClass(@PathVariable("id") Long id, Model model) {
		Course course = api.findOneCourse(id);
		List<Student> enrollees = api.findStudentsNotEnrolled(id);
		model.addAttribute("course", course);
		model.addAttribute("enrollees", enrollees);
		return "/classes/show.jsp";
	}
	
	// Dorms - Add|Drop student
	@RequestMapping(value="/dorms/{id}/addStudent", method=RequestMethod.POST)
	public String addStudent(
			@PathVariable("id") Long dormId,
			@RequestParam(name="studentId") Long studentId) {
		api.addStudent(dormId, studentId);
		return "redirect:/dorms/" + dormId;
	}
	
	@RequestMapping("/dorms/{dormId}/remove/{studentId}")
	public String removeStudent(
			@PathVariable("dormId") Long dormId,
			@PathVariable("studentId") Long studentId) {
		api.removeStudent(dormId, studentId);
		return "redirect:/dorms/" + dormId;
	}
	
	// Classes - Add|Drop student
	@RequestMapping(value="/classes/{id}/addStudent", method=RequestMethod.POST)
	public String enroll(
			@PathVariable("id") Long courseId,
			@RequestParam(name="studentId") Long studentId) {
		api.enroll(courseId, studentId);
		return "redirect:/classes/" + courseId;
	}
	
	@RequestMapping(value="/classes/{studentId}/addClass", method=RequestMethod.POST)
	public String addClass(
			@PathVariable("studentId") Long studentId,
			@RequestParam(name="courseId") Long courseId) {
		api.enroll(courseId, studentId);
		return "redirect:/students/" + studentId;
	}
	
	@RequestMapping("/classes/{courseId}/drop/{studentId}")
	public String drop(
			@PathVariable("courseId") Long courseId,
			@PathVariable("studentId") Long studentId) {
		api.drop(courseId, studentId);
		return "redirect:/classes/" + courseId;
	}

}
