package mypack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*Write a program using constructor overloading. create a class Person with Id, Name, Designation.
 *  Ask the user what are his inputs and according to that call the constructor. For Eg: If he wants to add only ID and name
 *  then Desgination will be default data or else if he wants to add Name and designation then ID will be default data.*/

class Person{//Class Person
	int id;//Data Members
	String name;
	String desgination;
	Person(int id,String name){//Construtor
		this.id=id;
		this.name=name;
	}
	Person(String name,String desgination){//Construtor
		this.name=name;
		this.desgination=desgination;
	}
	void display() {//display method
		System.out.println("Id: "+id+"\nName: "+name+"\nDesignation: "+desgination+"\n");
	}
}

public class UsePerson {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter id :");
		int id=Integer.parseInt(sc.readLine());//taking input 
		System.out.print("Enter Name :");
		String name=sc.readLine();//taking input 
		
		Person p=new Person(id,name);//creating a obj
		p.display();//method calling
		
		System.out.print("Enter Name :");
		String name1=sc.readLine();//taking input 
		System.out.print("Enter Designation :");
		String de=sc.readLine();//taking input 
		
		Person p1=new Person(name1,de);//creating a obj
		p1.display();//method calling
	}

}
