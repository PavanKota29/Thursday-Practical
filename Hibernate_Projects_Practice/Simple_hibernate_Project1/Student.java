package com.project2.HibernatePro1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//annotations of table and Entity
@Entity
@Table(name="Stud")

public class Student {
	
	//annotation of table column
	@Id
	@Column(name="Sid")
	private int sid;
	@Column(name="Sname")
	private String sname;
	@Column(name="Sage")
	private int sage;
	
	//getters and setters methods for private data members in class
	public int getSid() {
		return sid;
	}
	public void setSid(int string) {
		this.sid = string;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	
	
}
