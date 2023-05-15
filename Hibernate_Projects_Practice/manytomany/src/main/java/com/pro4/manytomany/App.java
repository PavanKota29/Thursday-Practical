package com.pro4.manytomany;

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
        //session factory object
    	SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	
    	//Session object
    	Session s=sf.openSession();
    	
    	//EmpDemo Objects
    	EmpDemo e1,e2,e3;
    	e1=new EmpDemo();
    	e1.setEid(101);
    	e1.setEname("Viju");
    	
    	e2=new EmpDemo();
    	e2.setEid(102);
    	e2.setEname("Pavan");
    	
    	e3=new EmpDemo();
    	e3.setEid(103);
    	e3.setEname("XYZ");
    	
    	
    	List<EmpDemo> eli1,eli2;
    	eli1=new ArrayList<EmpDemo>();
    	eli1.add(e1);
    	eli1.add(e2);
    	
    	eli2=new ArrayList<EmpDemo>();
    	eli2.add(e1);
    	eli2.add(e2);
    	eli2.add(e3);
    	
    	//ProDemo Objects
    	ProDemo p1,p2,p3;
    	p1=new ProDemo();
    	p1.setPid(301);
    	p1.setPname("Ai Based Website");
    	
    	p2=new ProDemo();
    	p2.setPid(302);
    	p2.setPname("Ai Based App");
    	
    	p3=new ProDemo();
    	p3.setPid(303);
    	p3.setPname("Ai Based chatbot");
    	
    	
    	List<ProDemo> pli1,pli2;
    	pli1=new ArrayList<ProDemo>();
    	pli1.add(p1);
    	pli1.add(p2);
    	
    	pli2=new ArrayList<ProDemo>();
    	pli2.add(p2);
    	pli2.add(p3);
    	
    	
    	//setting project to employee
    	e1.setPro(pli2);
    	e2.setPro(pli1);
    	e3.setPro(pli2);
    	
    	//setting employee to project
    	p1.setEmp(eli2);
    	p2.setEmp(eli1);
    	p3.setEmp(eli2);
    	
    	//Transaction object
    	Transaction t=s.beginTransaction();
    	
    	s.save(e1);
    	s.save(e2);
    	s.save(e3);
    	
    	s.save(p1);
    	s.save(p2);
    	s.save(p3);
    	
    	t.commit();
    	s.close();    	
    }
}
