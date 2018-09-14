package com.autism.AutismAppServer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autism.AutismAppServer.dto.QuestionDTO;
import com.autism.AutismAppServer.service.QuestionService;

@CrossOrigin
@RestController
@RequestMapping(value = "/autism")
public class QuestionController {

	@Autowired
	QuestionService questionService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "Authorization", value = "Token", required = true, dataType = "String", paramType = "header", defaultValue = "bearer ") })
	@RequestMapping(value = "/question", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllQuestions(HttpServletRequest request) {
		try {
			List<QuestionDTO> questionDTOs = questionService.getAllQuestions();
			return new ResponseEntity<>(questionDTOs, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception getAllQuestions", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);

		}

	}

}
