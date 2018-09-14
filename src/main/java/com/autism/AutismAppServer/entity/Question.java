package com.autism.AutismAppServer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;

	@Column(name = "que_id")
	private String queId;

	@Column(name = "que")
	private String que;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQueId() {
		return queId;
	}

	public void setQueId(String queId) {
		this.queId = queId;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", queId=" + queId + ", que=" + que + "]";
	}

}
