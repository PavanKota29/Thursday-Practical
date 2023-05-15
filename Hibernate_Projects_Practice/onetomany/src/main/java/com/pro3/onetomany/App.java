package com.pro3.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        //Session Factory
    	SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//Session 
    	Session s=sf.openSession();
    	
    	//Transaction 
    	Transaction t=s.beginTransaction();
    	
    	//Object of Employee
    	Employee e1,e2;
    	
    	e1=new Employee();
    	e1.setId(101);
    	e1.setName("Pavan");
    	e1.setDes("Developer");
    	
    	e2=new Employee();
    	e2.setId(102);
    	e2.setName("XYZ");
    	e2.setDes("Developer");
    	
    	//Object for Project
    	Project p1,p2,p3;
    	p1=new Project();
    	p1.setPid(301);
    	p1.setPname("Ai Based Project");
    	p1.setE(e1);
    	
    	p2=new Project();
    	p2.setPid(302);
    	p2.setPname("Ai Based Web site");
    	p2.setE(e2);
    	
    	p3=new Project();
    	p3.setPid(303);
    	p3.setPname("Ai Based Application");
    	p3.setE(e2);
    	
    	
    	//Adding all objects into List and set as employee
    	List<Project> l1,l2;
    	l1=new ArrayList<Project>();
    	l1.add(p1);
    	l1.add(p3);
    	
    	l2=new ArrayList<Project>();
    	l2.add(p2);
    	
    	e1.setP(l1);
    	e2.setP(l2);
    	
    	//Save objects 
    	s.save(e1);
    	s.save(e2);
    	
    	s.save(p2);
    	s.save(p1);
    	s.save(p3);
    	
    	//Commit and close the connections
    	t.commit();
    	
    	Employee e=s.get(Employee.class, 102);
    	System.out.println(e.getId());
    	System.out.println(e.getName());
    	System.out.println(e.getDes());
    	for(Project p:e.getP()) {
    		System.out.println(p.getPname());
    	}
    	
    	s.close();
    	
    	
    }
}
