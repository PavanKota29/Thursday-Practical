package com.mypack;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Onetomany {
	public static void main(String[] args) {
		
		//Session Factory
		SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//Session
		Session s=sf.openSession();
		
		//Question object
		Question q1,q2;
		q1=new Question();
		q1.setQid(101);
		q1.setQues("Java is .........");
		
		q2=new Question();
		q2.setQid(102);
		q2.setQues("Python is .........");
		
		//Answer Object
		Answer a1,a2,a3;
		a1=new Answer();
		a1.setAid(301);
		a1.setAnsw("Programming language");
		a1.setQuestion(q1);
		
		a2=new Answer();
		a2.setAid(302);
		a2.setAnsw("Object Oriented Programming");
		a2.setQuestion(q1);
		
		a3=new Answer();
		a3.setAid(303);
		a3.setAnsw("Simply Language");
		a3.setQuestion(q2);
		
		List<Answer> l1,l2;
		l1=new ArrayList<Answer>();
		l1.add(a1);
		l1.add(a2);
		
		l2=new ArrayList<Answer>();
		l2.add(a3);
		
		//seting list to question
		q1.setAnswer(l1);
		q2.setAnswer(l2);
		
		//saving the object into tables
		Transaction t=s.beginTransaction();
		
		s.save(q1);
		s.save(a1);
		s.save(a2);
		s.save(q2);
		s.save(a3);
	
		t.commit();
		Question q=s.get(Question.class, 102);
		System.out.println(q.getQid());
		System.out.println(q.getQues());
		for(Answer a:q.getAnswer()) {
			System.out.println(a.getAnsw());
		}
		
		s.close();
	}
}
