package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeTable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int eid;
	private String ename;
	private int sal;
	private int age;
	
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public EmployeeTable(int eid, String ename, int sal, int age) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
		this.age = age;
	}
	
	public EmployeeTable() {
		super();
	}
	
}
