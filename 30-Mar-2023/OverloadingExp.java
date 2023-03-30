class OverloadProg{//class declaration
	
	void add(int a,int b) {//Overloading method with 2 parameter
		System.out.println("This is two parameter Add method calling !!!");
	}
	void add(int a,int b,int c) {//Overloading method with 3 parameter
		System.out.println("This is Three parameter Add method calling !!!");
	}
}

public class OverloadingExp {
	public static void main(String[] args) {
		OverloadProg p=new OverloadProg();//Obj creating for class 
		p.add(10, 20);//calling the  add method with parameter
		p.add(10, 20, 30);//calling the add metod with parameter
	}

}
