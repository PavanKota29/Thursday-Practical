package com.pro1.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class App 
{
    public static void main( String[] args )
    {
    	//in this line creating sessionfactory object using configuration() and bulidsessionfactoty()
//    	Configuration cfg=new Configuration();
//    	cfg.configure("hibernate.cfg.xml");
        SessionFactory sf=new Configuration().configure().buildSessionFactory();
        
        //in this line session will open or session will created 
        Session s=sf.openSession();
        
        //in this line Transaction will begin
        Transaction t=s.beginTransaction();
        
        //Creating object of Department
        Department d1=new Department();
        d1.setId(301);
        d1.setName("Developer");
        
        Department d2=new Department();
        d2.setId(302);
        d2.setName("HR");
        
        Department d3=new Department();
        d3.setId(303);
        d3.setName("Junior Developer");
        
        //creating the object for Employee
        Employee e1=new Employee();
        e1.setId(101);
        e1.setName("Pavan");
        e1.setD(d1);
        
        Employee e2=new Employee();
        e2.setId(102);
        e2.setName("Viju");
        e2.setD(d1);
        
        Employee e3=new Employee();
        e3.setId(103);
        e3.setName("Rahul");
        e3.setD(d2);
        
        Employee e4=new Employee();
        e4.setId(104);
        e4.setName("Ravi");
        e4.setD(d3);
        
        Employee e5=new Employee();
        e5.setId(105);
        e5.setName("XYZ");
        e5.setD(d2);
        
        //inserting object into table
        s.save(e1);
        s.save(e2);
        s.save(e3);
        s.save(e4);
        s.save(e5);
        
        s.save(d1);
        s.save(d2);
        s.save(d3);
         
        
        t.commit();
        s.close();
        
    }
}
