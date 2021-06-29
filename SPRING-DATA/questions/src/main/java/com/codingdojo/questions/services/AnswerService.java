package com.codingdojo.questions.services;

import org.springframework.stereotype.Service;

import com.codingdojo.questions.models.Answer;
import com.codingdojo.questions.repositories.AnswerRepository;



@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository aRepository) {
		this.answerRepository = aRepository;
	}
	
	public Answer addAnswer(Answer answer) {
		return this.answerRepository.save(answer);
	}
}
