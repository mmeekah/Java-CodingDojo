package com.codingdojo.questions.services;

import org.springframework.stereotype.Service;

import com.codingdojo.questions.models.Tag;
import com.codingdojo.questions.repositories.TagRepository;



@Service
public class TagService {
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tRepository) {
		this.tagRepository = tRepository;
	}
	
	public Tag findTagBySubject(String subject) {
		return tagRepository.findBySubject(subject);
	}
	
	public Tag addTag(Tag t) {
		return tagRepository.save(t);
	}

}
