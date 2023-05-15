package com.project1.EmployeeDataBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


//This is for Table 
@Entity
@Table(name="Employee1")

public class Emp {
	
	//This is for Column of table
	@Id @Column(name="Eid") private int id;
	@Column(name="Ename") private String name;
	@Column(name="Esalary") private int sal;
	
	//Getter and Setter Method For Data Members of class
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	

}
