package com.project3.EmployeeExp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	//session factory object is creating 
        SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        
        //creating session object
        Session s=sf.openSession();
        
        Transaction t=s.beginTransaction();
        
        //Employee class object creating adding values to it
        
        Employee e1=new Employee();
        e1.setEid(101);
        e1.setEname("Pavan");
        e1.setEdesignation("Developer");
        
        Employee e2=new Employee();
        e2.setEid(102);
        e2.setEname("Viju");
        e2.setEdesignation("Junior Developer");
        
        Employee e3=new Employee();
        e3.setEid(103);
        e3.setEname("XYZ");
        e3.setEdesignation("Web Developer");
        
        //Project class object creating and adding values to it
        
        Project p1=new Project();
        p1.setPid(301);
        p1.setPname("AI-based Tic Tac Toe Game");
        p1.setPdescription("AI Based Game");
        
        Project p2=new Project();
        p2.setPid(302);
        p2.setPname("Build a Graphic Calculator");
        p2.setPdescription("Building Calculator");
        
        Project p3=new Project();
        p3.setPid(303);
        p3.setPname("Netflix Home Page Clone");
        p3.setPdescription("Creating a Netflix Home page");
        
        
        e1.setP(p1);
        e2.setP(p2);
        e3.setP(p3);
        
        p1.setE(e1);
        p2.setE(e2);
        p3.setE(e3);
        
        //saving all object in a table
        s.save(e1);
        s.save(e2);
        s.save(e3);
        
        s.save(p1);
        s.save(p2);
        s.save(p3);
        
        
        //Data showing
        List<Employee> li=s.createQuery("from Employee").list();
        System.out.println();
        for(Employee e:li) {
        	System.out.println(e.getEid()+" "+e.getEname()+" "+e.getEdesignation()+" "
        			+ e.getP().getPid()+" "+e.getP().getPname()+"--> "+e.getP().getPdescription());
        }
        //closing connections
        t.commit();
        s.close();
        
    }
}
