package com.project3.EmployeeExp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//Entity class or mapping class
@Entity
@Table(name="Employe")
public class Employee {
	//column in table 
	@Id
	@Column(name="eid")
	private int eid;
	
	@Column(name="ename")
	private String ename;
	
	@Column(name="edesignation")
	private String edesignation;
	
	@OneToOne
	@JoinColumn(name="pid")
	private Project p;
	
	//getter setter methods
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}
	
	
}
