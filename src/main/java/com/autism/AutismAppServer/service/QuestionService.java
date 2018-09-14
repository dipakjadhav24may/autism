package com.autism.AutismAppServer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.autism.AutismAppServer.dao.QuestionDao;
import com.autism.AutismAppServer.dto.QuestionDTO;
import com.autism.AutismAppServer.entity.Question;

@Component
public class QuestionService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	QuestionDao questionDao;

	public List<QuestionDTO> getAllQuestions() {

		List<QuestionDTO> questionDTOs = new ArrayList<>();

		try {
			List<Question> questionList = (List<Question>) questionDao.findAll();
			for (Question question : questionList) {
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setQuestionId(question.getQuestionId());
				questionDTO.setQueId(question.getQueId());
				questionDTO.setQue(question.getQue());
				questionDTOs.add(questionDTO);
			}

		} catch (Exception e) {
			logger.error("Exception getAllQuestions service", e);
			e.printStackTrace();
		}

		return questionDTOs;

	}

}
