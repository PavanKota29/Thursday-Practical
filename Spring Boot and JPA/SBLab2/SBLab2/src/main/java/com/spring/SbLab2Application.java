package com.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.spring.entity.MyEmployee;
import com.spring.repo.EmpRepo;

@SpringBootApplication
public class SbLab2Application {

	public static void main(String[] args) {
		ApplicationContext con= SpringApplication.run(SbLab2Application.class, args);
		
		EmpRepo er=con.getBean(EmpRepo.class);
		
		
		//Creating Oject Of MyEmployee Class Object Add Values to it
//		MyEmployee e1,e2,e3,e4;
//		
//		e1=new MyEmployee(101,"XYZ",30000);
//		e2=new MyEmployee(102,"ABC",45000);
//		e3=new MyEmployee(103,"QWE",34000);
//		e4=new MyEmployee(104,"TYR",67000);
//		
//		//Inserting data into table
//		List<MyEmployee> li=List.of(e1,e2,e3,e4);
		
		//this er.saveAll() is insert the all object into table
//		er.saveAll(li).forEach(obj ->{
//			System.out.println(obj);
//		});
		
		//Updating the values of tables
//		MyEmployee m=er.findById(103).get();
//		m.setEname("Pavan Kota");
//		er.save(m);//This line update the data

		
		//Deleting data
		er.deleteById(104);
		System.out.println("Data Deleted !!!");
		
		//disaply data
		er.findAll().forEach(obj ->{
			System.out.println(obj);
		});
		
		
	}

}
