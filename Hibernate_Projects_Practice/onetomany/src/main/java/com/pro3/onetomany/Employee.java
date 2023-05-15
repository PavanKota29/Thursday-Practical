package com.pro3.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This is for table 
@Entity
@Table(name="Employee1")
public class Employee {
	
	//For Column
	@Id
	@Column(name="Eid")
	private int id;
	
	@Column(name="Ename")
	private String name;
	
	@Column(name="Edes")
	private String des;
	
	@OneToMany(mappedBy = "e")
	private List<Project> p;
	
	//getter setter methods
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public List<Project> getP() {
		return p;
	}

	public void setP(List<Project> p) {
		this.p = p;
	}
	
	
	
	
}
