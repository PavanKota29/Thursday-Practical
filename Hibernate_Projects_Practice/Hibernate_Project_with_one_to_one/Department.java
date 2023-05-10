package com.pro1.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//table name
@Entity
@Table(name="dept")
public class Department {
	
	//table columns
	@Id
	@Column(name="did")
	private int id;
	
	@Column(name="dname")
	private String name;

	//Getter Setter Methods
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
