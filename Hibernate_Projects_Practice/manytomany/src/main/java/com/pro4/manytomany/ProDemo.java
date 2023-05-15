package com.pro4.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ProDemo {
	@Id
	private int pid;
	private String pname;
	
	@ManyToMany(mappedBy = "pro")
	private List<EmpDemo> emp;

	//getter setter methods
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

	public List<EmpDemo> getEmp() {
		return emp;
	}

	public void setEmp(List<EmpDemo> emp) {
		this.emp = emp;
	}
	
	
}
