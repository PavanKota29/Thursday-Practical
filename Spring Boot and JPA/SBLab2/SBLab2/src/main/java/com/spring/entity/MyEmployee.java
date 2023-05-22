package com.spring.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyEmployee {
	
	@Id
	private int eid;
	private String ename;
	private int sal;
	
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
	
	
	public MyEmployee(int eid, String ename, int sal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.sal = sal;
	}
	
	
	public MyEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "MyEmployee [eid=" + eid + ", ename=" + ename + ", sal=" + sal + "]";
	}	
}

