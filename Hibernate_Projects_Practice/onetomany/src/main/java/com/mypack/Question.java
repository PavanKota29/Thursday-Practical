package com.mypack;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Que")
public class Question {
	
	@Id
	@Column(name="qid")
	private int qid;
	
	@Column(name="ques")
	private String ques;
	
	@OneToMany(mappedBy = "question")
	private List<Answer> answer;
	
	//Getter setter methods
	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}
	
	
}
