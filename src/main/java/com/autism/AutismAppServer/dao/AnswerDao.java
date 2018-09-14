package com.autism.AutismAppServer.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.autism.AutismAppServer.entity.Answer;

@Transactional
public interface AnswerDao extends CrudRepository<Answer, Integer> {

	@Query(value = "select * from answer where user_id=?1", nativeQuery = true)
	Answer findAllAnswerByUser(int userId);
}
