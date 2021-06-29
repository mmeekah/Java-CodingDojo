package com.codingdojo.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.NewQuestion;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.AnswerRepository;
import com.codingdojo.overflow.repositories.QuestionRepository;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class AppService {
	private QuestionRepository questionRepo;
	private AnswerRepository answerRepo;
	private TagRepository tagRepo;
	
	public AppService(QuestionRepository questionRepo, AnswerRepository answerRepo, TagRepository tagRepo) {
		this.questionRepo = questionRepo;
		this.answerRepo = answerRepo;
		this.tagRepo = tagRepo;
	}
	
	// Question Service
	public List<Question> findAllQuestions() {
		return questionRepo.findAll();
	}
	
	public Question findQuestion(Long id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public Question createQuestion(NewQuestion q) {
		List<Tag> tempTags = new ArrayList<Tag>();
		for (String subject: q.splitTags()) {
			Tag tag = tagRepo.findBySubject(subject).orElse(null);
			if (tag == null) {
				tag = new Tag(subject);
				tagRepo.save(tag);
			}
			if (!tempTags.contains(tag)) {
				tempTags.add(tag);
			}
		}
		Question question = new Question(q.getQuestion(), tempTags);
		return questionRepo.save(question);
	}
	
	// Answer Service
	public Answer createAnswer(Answer a) {
		return answerRepo.save(a);
	}
	
}