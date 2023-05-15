package com.mypack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ans")
public class Answer {
	
	@Id
	@Column(name="aid")
	private int aid;
	
	@Column(name="Answ")
	private String answ;
	
	@ManyToOne
	private Question question;
	
	//Getter setter methods
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAnsw() {
		return answ;
	}

	public void setAnsw(String answ) {
		this.answ = answ;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
