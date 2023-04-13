package Pack1;

import java.util.Scanner;

/*2. Write a program to create thread. Where you will 
 * take the input from the user and find if the number is odd or even.*/

class MyThread2 extends Thread{//extending thread class
	int n;
	public MyThread2(int n){//constructor
		this.n=n;
	}
	public void run() {//Run method
		if(n%2==0) {	//checking condition
			System.out.println("Number is Even !!!");
		}else {
			System.out.println("Number is Odd !!!");
		}
	}
}

public class UseThreadExp {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Number :");
		MyThread2 m=new MyThread2(sc.nextInt());//creating obj
		m.start();//using start() run the thread
	}
}
