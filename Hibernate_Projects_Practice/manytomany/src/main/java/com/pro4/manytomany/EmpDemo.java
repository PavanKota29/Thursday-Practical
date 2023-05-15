package com.pro4.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class EmpDemo {
	@Id
	private int eid;
	private String ename;
	
	@ManyToMany
	@JoinTable(name = "Emp_Pro", 
	joinColumns  = {@JoinColumn(name="Eid")},
	inverseJoinColumns = {@JoinColumn(name="Pid")})
	private List<ProDemo> pro;
	
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

	public List<ProDemo> getPro() {
		return pro;
	}

	public void setPro(List<ProDemo> pro) {
		this.pro = pro;
	}
	
	
}
