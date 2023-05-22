package com.spring;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.entity.Stud;
import com.spring.repo.StudRepo;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		//SpringApplication return ApplicatonContext
		ApplicationContext con= SpringApplication.run(StudentApplication.class, args);
		
		//Getting Stud
		StudRepo st=con.getBean(StudRepo.class);
		
		//Creating object of Stud
		Stud s1,s2;
		s1=new Stud();
		s1.setSid(101);
		s1.setMarks(86);
		s1.setEname("XYZ");
		
		s2=new Stud();
		s2.setSid(102);
		s2.setMarks(86);
		s2.setEname("PQR");
		
//		//Saving the Object into tables
//		Stud st1,st2;
//		st1= st.save(s1);
//		st2= st.save(s2);
//		
//		//Printing Objects 
//		System.out.println(st1);
//		System.out.println(st2);
		
		
		List<Stud> li=List.of(s1,s2);
		
		//Iterator<Stud> it1=st.saveAll(li).iterator();
		
//		while(it1.hasNext()) {
//			System.out.println(it1.next());
//		}
		
		//st.saveAll(li).forEach(obj -> System.out.println(obj));
		
		
		
		
		//Updating Values
//		Optional<Stud> op= st.findById(101);
//		Stud st3=op.get();
//		st3.setEname("xyz");
//		
//		System.out.println(st.save(st3));
		
		
		
//		//getting all data from database
//		
//		Iterator<Stud> itr=st.findAll().iterator();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		
//		st.findAll().forEach(obj -> System.out.println(obj));
		
		
		//deleting data from database
		
		st.deleteById(101);
		System.out.println("Deleted Data !!!");
		
	}

}
