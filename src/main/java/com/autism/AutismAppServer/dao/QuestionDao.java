package com.autism.AutismAppServer.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.autism.AutismAppServer.entity.Question;

@Transactional
public interface QuestionDao extends CrudRepository<Question, Integer>  {
	
	@Query(value = "select * from question where que_id=?1", nativeQuery = true)
	Question findQuestion(String questionId);

	
	

}
