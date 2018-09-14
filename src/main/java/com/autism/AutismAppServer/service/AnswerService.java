package com.autism.AutismAppServer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.autism.AutismAppServer.dao.AnswerDao;
import com.autism.AutismAppServer.dao.ChildUserDao;
import com.autism.AutismAppServer.dao.ParentUserDao;
import com.autism.AutismAppServer.dao.QuestionDao;
import com.autism.AutismAppServer.dto.AnswerDTO;
import com.autism.AutismAppServer.dto.QuestionDTO;
import com.autism.AutismAppServer.entity.Answer;
import com.autism.AutismAppServer.entity.ParentUser;
import com.autism.AutismAppServer.entity.Question;
import com.autism.AutismAppServer.util.MailUtil;

@Component
public class AnswerService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${autism.toemailAddress}")
	private String toEmailAddress;

	@Value("${autism.toName}")
	private String toName;

	@Autowired
	QuestionDao questionDao;

	@Autowired
	AnswerDao answerDao;

	@Autowired
	MailUtil mailUtil;

	@Autowired
	ParentUserDao parentUserDao;

	@Autowired
	ChildUserDao childUserDao;

	public void saveAnswerQuestion(List<AnswerDTO> answerDTOList) {

		StringBuffer stringBuffer = new StringBuffer();
		String parentUserName="";
		StringBuffer stringAnswer=new StringBuffer();
		stringBuffer.append("Dear " + toName + "," + "<br></br><br></br>");
		try {
			for (AnswerDTO answerDTO : answerDTOList) {
				Question question = questionDao.findQuestion(answerDTO.getQuestionId());

				if (question != null) {

					ParentUser parentUser = checkParentUserIdExist(answerDTO.getUserId());					
					parentUserName="Name: " + parentUser.getFirstName()+" "+parentUser.getLastName();

					if (parentUser != null) {
						Answer answer = new Answer();
						stringAnswer.append("Question: " + question.getQue() + "<br></br>"+"Answer: " + answerDTO.getAnswer() + "<br></br><br></br>");
						answer.setAnswer(answerDTO.getAnswer());
						answer.setQueId(question.getQueId());
						answer.setUserId(answerDTO.getUserId());
						answer.setStatus(answerDTO.getStatus());
						answerDao.save(answer);
					}

				}

			}
			
			stringBuffer.append( parentUserName+ "<br></br><br></br>");
			stringBuffer.append(stringAnswer);

			mailUtil.sendmail(stringBuffer.toString(), toEmailAddress, "Question Answer List");

		} catch (Exception e) {
			logger.error("Exception saveAnswerQuestion service", e);
			e.printStackTrace();
		}

	}

	public ParentUser checkParentUserIdExist(int userId) {

		return parentUserDao.findOne(userId);

	}

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

	public AnswerDTO getAnswerById(int answerId) {

		AnswerDTO answerDTO = new AnswerDTO();
		try {

			Answer answer = answerDao.findOne(answerId);
			if (answer != null) {
				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setAnswerId(answer.getAnswerId());
				answerDTO.setQuestionId(answer.getQueId());
				answerDTO.setUserId(answer.getUserId());
				answerDTO.setStatus(answer.getStatus());

			}

		} catch (Exception e) {
			logger.error("Exception getAnswerById service", e);
			e.printStackTrace();
		}

		return answerDTO;

	}

	public List<AnswerDTO> getAllAnswers() {

		List<AnswerDTO> answerDTOs = new ArrayList<>();

		try {
			List<Answer> answerList = (List<Answer>) answerDao.findAll();
			for (Answer answer : answerList) {
				AnswerDTO answerDTO = new AnswerDTO();

				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setAnswerId(answer.getAnswerId());
				answerDTO.setQuestionId(answer.getQueId());
				answerDTO.setUserId(answer.getUserId());
				answerDTO.setStatus(answer.getStatus());
				answerDTOs.add(answerDTO);
			}

		} catch (Exception e) {
			logger.error("Exception getAllAnswers service", e);
			e.printStackTrace();
		}

		return answerDTOs;

	}

	@SuppressWarnings("unchecked")
	public List<AnswerDTO> getAllAnswersByUserId(int userId) {

		List<AnswerDTO> answerDTOs = new ArrayList<>();

		try {
			List<Answer> answerList = (List<Answer>) answerDao.findAllAnswerByUser(userId);
			for (Answer answer : answerList) {
				AnswerDTO answerDTO = new AnswerDTO();

				answerDTO.setAnswer(answer.getAnswer());
				answerDTO.setAnswerId(answer.getAnswerId());
				answerDTO.setQuestionId(answer.getQueId());
				answerDTO.setUserId(answer.getUserId());
				answerDTO.setStatus(answer.getStatus());
				answerDTOs.add(answerDTO);
			}

		} catch (Exception e) {
			logger.error("Exception getAllAnswers service", e);
			e.printStackTrace();
		}

		return answerDTOs;

	}

}
