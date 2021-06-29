package com.codingdojo.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	 // this method finds books by id
    Optional<Language> findById(Long id);
    // this method deletes a book by id
    void deleteById(Long id);
}
