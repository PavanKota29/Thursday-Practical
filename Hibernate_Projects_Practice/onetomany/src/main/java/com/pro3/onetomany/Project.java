package com.pro3.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//for table
@Entity
@Table(name="Project1")
public class Project {
	
	//For Column
	@Id @Column(name="Pid")
	private int pid;
	
	@Column(name="pname")
	private String pname;
	
	@ManyToOne
	private Employee e;
	
	//getter setter methods
	public Employee getE() {
		return e;
	}

	public void setE(Employee e) {
		this.e = e;
	}
	
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
