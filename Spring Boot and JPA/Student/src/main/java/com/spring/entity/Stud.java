package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stud {
	@Id
	private int sid;
	private String ename;
	private int marks;
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Stud [sid=" + sid + ", ename=" + ename + ", marks=" + marks + "]";
	}
	
	

}
