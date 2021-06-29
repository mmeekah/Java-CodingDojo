package com.codingdojo.questions.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.questions.models.Answer;
import com.codingdojo.questions.models.Question;
import com.codingdojo.questions.models.User;
import com.codingdojo.questions.models.Tag;
import com.codingdojo.questions.services.AnswerService;
import com.codingdojo.questions.services.QuestionService;
import com.codingdojo.questions.services.TagService;
import com.codingdojo.questions.services.UserService;


@Controller
@RequestMapping("/questions")
public class QuestionController {
	
	private final UserService userService;
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	public QuestionController(UserService uService, QuestionService qService, TagService tService, AnswerService aService) {
		this.userService = uService;
		this.tagService = tService;
		this.questionService = qService;
		this.answerService = aService;
	}
	
	@RequestMapping("")
    public String dashboard(HttpSession session, RedirectAttributes redirectAttributes, Model model) {
    	if(session.getAttribute("user_id") == null) {
    		// user is not logged in
    		redirectAttributes.addFlashAttribute("success_error", "Must be logged in to continue");
    		return "redirect:/login";
    	}
    	model.addAttribute("allQuestions", questionService.getAll());
        return "dashboard.jsp";
    }
	
	@RequestMapping("/new")
	public String newQuestion() {
		return "new.jsp";
	}
	
	@RequestMapping("/{question_id}")
	public String showQuestion(@PathVariable("question_id") Long id, Model model) {
		Question question = questionService.getQuestionById(id);
		model.addAttribute("oneQuestion", question);
		return "show.jsp";
	}
	
	@PostMapping("/{question_id}")
	public String addAnswer(@PathVariable("question_id") Long id, @RequestParam("answer") String answer) {
		Question question = questionService.getQuestionById(id);
		Answer newAnwser = new Answer(answer, question);
		answerService.addAnswer(newAnwser);
		return "redirect:/questions/" + id;
	}
	
	@PostMapping("")
	public String addQuestion(@RequestParam("question") String quest, @RequestParam("tags") String tags, HttpSession session) {
		// get user object, from the id in session
		System.out.println("--------------------------------------------------");		Long user_id = (Long)session.getAttribute("user_id");
		User logged_in_user = userService.findUserById(user_id);
		System.out.println(logged_in_user);
		
		Question newQuestion = new Question(quest, logged_in_user);
		System.out.println(newQuestion);
//		
//		// handle the tag creation
//		// separate the tags by commas
		List<Tag> questionTags = newQuestion.getTags();
		
		String[] arrOfTags = tags.split(",");
		for(String tag:arrOfTags) {
			System.out.println(tag.trim());
			// get the tag object
			Tag tagInDB = tagService.findTagBySubject(tag);
			// create a new tag, and add to question tag list
			if(tagInDB == null) {
				// add tag to DB, then add tag to question
				Tag newTag = new Tag(tag);
				Tag savedTag = tagService.addTag(newTag);
				// add the tag to the question
				questionTags.add(savedTag);
			} else {
				// add tag to question that was in DB
				questionTags.add(tagInDB);
			}
			newQuestion.setTags(questionTags);
			
		}
		// save the question, and the many-to-many relationship to DB, after we checked all tags from the form
		questionService.addQuestion(newQuestion);
		return "redirect:/questions";
	}
}
