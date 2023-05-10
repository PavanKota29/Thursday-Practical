package com.project2.HibernatePro1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
        //Configuration the hibernate file
//    	Configuration cfg=new Configuration();
//    	cfg.configure("hibernate.cfg.xml");
//    	cfg.addAnnotatedClass(Student.class);
    	
    	// session factory and session 
    	SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    	Session se=sf.openSession();
    	
    	//Transaction object is creating
    	Transaction t=se.beginTransaction();
    	
    	//inserting data into database
    	Student st=new Student();
    	st.setSid(103);
    	st.setSname("Pavan");
    	st.setSage(87);
    	
    	//inserting data into database 
    	se.save(st);
    	t.commit();
    	se.close();
   	
    	
    }
}
