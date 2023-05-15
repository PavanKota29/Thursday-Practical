package com.project1.EmployeeDataBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//annotations of tables name
@Entity
@Table(name="Stud")

public class Student {
	
	//annotation of table column
	@Id
	@Column(name="Sid")
	private int sid;
	@Column(name="Sname")
	private String sname;
	@Column(name="Smarks")
	private float smarks;
	
	//getters and setters methods
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getSmarks() {
		return smarks;
	}
	public void setSmarks(float smarks) {
		this.smarks = smarks;
	}
	
	
}
