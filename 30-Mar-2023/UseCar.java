//Parent class Vehicle
class Vehicle {//class declaration
 String brand;//data members
 String model;
 int year;

 public void drive() {//class member function
     System.out.println("Driving the vehicle");
 }
}

//Child class Car
class Car extends Vehicle {//class declaration
 String color;//data members

 public void Type() {//class member function
     System.out.println("This is a car");
 }
}


public class UseCar {//main class
	public class Main {
		 public static void main(String[] args) {
		     Car myCar = new Car();//creating Obj
		     
		     myCar.brand = "Toyota";
		     myCar.model = "Camry";
		     myCar.year = 2021;
		     myCar.color = "Red";
		     
		     myCar.drive();//calling method By obj 
		     myCar.Type();
		 }
		}
}
