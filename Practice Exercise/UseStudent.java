package Pack1;

/*Create a parent class called "Person" with attributes such as name, age, and a method 
called "speak". Create a child class called "Student" that inherits from Person 
and has an additional attribute called "grade" and a method called "study". 
Create an object of the Student class and call both the "speak" and "study" methods.*/

class Person{
	String name;
	int age;
	void speak() {
		System.out.println("This is Person class method speak !!!");
	}
}

class Student extends Person{
	String grade;
	void study() {
		System.out.println("This is Student method study !!!");
	}
}


class UseStudent {
	public static void main(String[] args) {
		Student s=new Student();
		s.name="Pavan";
		s.age=21;
		s.grade="A";
		s.speak();
		s.study();
	}

}
