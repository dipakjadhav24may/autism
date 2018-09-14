package com.autism.AutismAppServer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.autism.AutismAppServer.dto.AnswerDTO;
import com.autism.AutismAppServer.dto.ResponseDTO;
import com.autism.AutismAppServer.service.AnswerService;

@CrossOrigin
@RestController
@RequestMapping(value = "/autism")
public class AnswerController {

	@Autowired
	AnswerService answerService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public ResponseEntity<Object> saveAnswerQuestion(@RequestBody List<AnswerDTO> answerDTO,
			HttpServletRequest request) {
		try {
			answerService.saveAnswerQuestion(answerDTO);

			ResponseDTO responseDTO = new ResponseDTO();
			responseDTO.setId(200);
			responseDTO.setMessage("Answer Created Successfully");

			return new ResponseEntity<>(responseDTO, HttpStatus.OK);

		} catch (Exception ex) {
			logger.error("Exception saveAnswerQuestion", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/answer", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAnswerQuestion(HttpServletRequest request) {
		try {
			List<AnswerDTO> answerDTOs = answerService.getAllAnswers();

			return new ResponseEntity<>(answerDTOs, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception getAllAnswerQuestion", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/answer/{answer-id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAnswerById(@PathVariable("answer-id") int answerId, HttpServletRequest request) {
		try {
			AnswerDTO answerDTO = answerService.getAnswerById(answerId);

			return new ResponseEntity<>(answerDTO, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception getAllAnswerQuestion", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/answer/user/{user-id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAnswerByUser(@PathVariable("user-id") int userId, HttpServletRequest request) {
		try {
			List<AnswerDTO> answerDTOs = answerService.getAllAnswersByUserId(userId);

			return new ResponseEntity<>(answerDTOs, HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception getAllAnswerByUser", ex);
			return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
		}
	}

}
