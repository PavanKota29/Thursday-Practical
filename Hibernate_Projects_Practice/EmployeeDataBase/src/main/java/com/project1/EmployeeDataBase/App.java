package com.project1.EmployeeDataBase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	@SuppressWarnings("unchecked")
    public static void main( String[] args ) throws Exception
    {
    	//For Getting Input From users side
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	
    	//This is for Configuration 
        Configuration config=new Configuration();
        config.configure("hibernate.cfg.xml");
        config.addAnnotatedClass(Emp.class);
        
        //This is for Session Factory
        SessionFactory sf=config.buildSessionFactory();
        
        //Creating session 
        Session se=sf.openSession();
        
        //Creating a Transaction 
        Transaction t=se.beginTransaction();
        
        while(true) {
        	System.out.print("\n----Employee DataBase----\n1.Add Employee Records\n2.Update Employee Records\n"
        		+ "3.Delete Employee Records\n4.Show All Records\n5.Exit\nEnter Choice:");
        	
        	switch(Integer.parseInt(br.readLine())) {
        	
        	case 1:												//For Inserting Record into table  
        		Emp e1=new Emp();
        		System.out.print("\nEnter Employee Id:");
        		e1.setId(Integer.parseInt(br.readLine()));
        		
        		System.out.print("\nEnter Employee Name:");
        		e1.setName(br.readLine());
        		
        		System.out.print("\nEnter Employee Salary:");
        		e1.setSal(Integer.parseInt(br.readLine()));
        		se.save(e1);
        		t.commit();
        		System.out.println("Record Inserted into Table Successfully !!!!!");
        		break;
        		
        	case 2:												//For Updating Record in a table
        		System.out.print("\nEnter Employee Id:");
        		Emp e2=se.load(Emp.class, Integer.parseInt(br.readLine()));
        		System.out.print("\nWhat you want to Update 1.Employee Name or 2.Employee Salary\nEnter Choice:");
        		switch(Integer.parseInt(br.readLine())) {
        		case 1:
        			System.out.print("Enter Employee Name:");
        			e2.setName(br.readLine());
        			t.commit();
        			System.out.println("Employee Name is Updated Successfully !!!");
        			break;
        			
        		case 2:
        			System.out.print("Enter Employee Salary:");
        			e2.setSal(Integer.parseInt(br.readLine()));
        			t.commit();
        			System.out.println("Employee Salary is Updated Successfully !!!");
        			break;
        			
        		default:
        			System.out.println("Enter Valid Choice !!!");
        		}
        		break;
        	
        	case 3:													//For Deleting Record from table
        		System.out.print("\nEnter Employee Id:");
        		Emp e3=new Emp();
        		e3.setId(Integer.parseInt(br.readLine()));
        		se.delete(e3);
        		t.commit();
        		System.out.println("Employee Record is Deleted Successfully !!!");
        		break;
        		
        	case 4:													//For Displaying Records
        		
        		List<Emp> emp=se.createQuery("from Emp").list();
        		System.out.println("\nEmpID\t\tEname\t\tEsalary");
        		for(Emp obj:emp) {
        			System.out.println(obj.getId()+"\t\t"+obj.getName()+"\t\t"+obj.getSal());
        		}
        		break;
        	
        	case 5:													//For Exit
        		t.commit();
        		se.close();
        		System.exit(0);
        	
        	default:				
        		System.out.println("Enter Valid Choice !!!!!");
        	}
        }
    }
}
