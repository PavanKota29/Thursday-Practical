package Pack1;

/*Create a parent class called "Person" with attributes such as name, age, and a method 
called "speak". Create a child class called "Student" that inherits from Person 
and has an additional attribute called "grade" and a method called "study". 
Create an object of the Student class and call both the "speak" and "study" methods.*/

class Person{//Parent class
	String name;//data members
	int age;
	void speak() {//method
		System.out.println("This is Person class method speak !!!");
	}
}

class Student extends Person{//child class
	String grade;//data members
	void study() {//method
		System.out.println("This is Student method study !!!");
	}
}


class UseStudent {//main class
	public static void main(String[] args) {
		Student s=new Student();//object creating 
		s.name="Pavan";//values assigning
		s.age=21;
		s.grade="A";
		s.speak();//calling method
		s.study();
	}

}
