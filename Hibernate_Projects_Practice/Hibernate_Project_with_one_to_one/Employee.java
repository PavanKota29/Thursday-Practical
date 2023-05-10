package com.pro1.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//table name
@Entity
@Table(name="emp")
public class Employee {
	//table columns
	@Id
	@Column(name="eid")
	private int id;
	
	@Column(name="ename")
	private String name;
	
	@OneToOne
	private Department d;
	
	//Getter Setter Method
	public Department getD() {
		return d;
	}

	public void setD(Department d) {
		this.d = d;
	}

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
	
	
}
