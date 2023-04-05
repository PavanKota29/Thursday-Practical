package Pack1;
/*Create an interface called "BankAccount" with methods called "deposit" and "withdraw". 
 * Create a class called "CheckingAccount" that implements the BankAccount interface and 
implements the "deposit" and "withdraw" methods. Create an object of the CheckingAccount
 class and call both the "deposit" and "withdraw" methods.*/

interface BankAccount{//interface 
	public void deposit();
	public void withdraw();//Abstract method
}

class CheckingAccount implements BankAccount{//implementing the interface
	public void deposit() {//providing body to abstract method
		System.out.println("This is deposit method !!!");
	}
	public void withdraw() {
		System.out.println("This is withdraw method !!!");
	}
}

public class UseBank {
	public static void main(String[] args) {
		CheckingAccount c=new CheckingAccount();//obj creating 
		c.deposit();//calling the method
		c.withdraw();
	}
}
