//Write a java program. create a class Calculation add method 
//addition,substraction,multiplication and division to it.create a object and
//access thosemethods.

class Calculation{//Class Declaration 
	int addition(int a,int b){
		return a+b;
	}
	 int substraction(int a,int b){
		return a-b;
	}
	 int multiplication(int a,int b){
		return a*b;
	}
	 float division(int a,int b){
		return a/b;
	}
}
class Calculator{
	public static void main(String[] args) {
		Calculation a=new Calculation();
		System.out.println("Addition="+a.addition(10,20));
		System.out.println("Subtraction="+a.substraction(40,20));
		System.out.println("Multiplication="+a.multiplication(10,20));
		System.out.println("Division="+a.division(8,2));
	}
}