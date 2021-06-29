package com.codingdojo.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.events.models.Message;

public interface MessageRepository extends CrudRepository <Message, Long>{

}
