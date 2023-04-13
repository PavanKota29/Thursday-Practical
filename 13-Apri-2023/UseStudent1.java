package Pack1;
/*1. Write a program to take input of marks of 3 subjects from the user. 
 * Check if the total of marks given by the user is greater than 
 * 50 else throw an exception saying "You Failed". Or else print Grade 
 * is A if the total is greater than 280. Grade B if the total is greater 
 * than 200. Grade C if the total is greater than 150. Grade D if the total is greater than 50.*/
import java.util.Scanner;

class Invalidmarks extends Exception{//class invalidmarks for user defind exception 
	
	public Invalidmarks(String str) {//constructor of class  
		super(str);
	}
}

public class UseStudent1 {
	public static void checkMarks(int m) throws Invalidmarks { //method for checking the 
		if(m<50) {
			throw new Invalidmarks("You Failed");//throwing the user defind exception
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 3 Subject Marks:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		int re=a+b+c;
		try {
			checkMarks(re);//checking if given marks are less than 50 than throws an a user defind exception
		} catch (Invalidmarks e) {
			System.out.println(e);
		}
		if(re>280) {//check the condition
			System.out.println("Grade A");
		}else if(re>200) {
			System.out.println("Grade B");
		}else if(re>150) {
			System.out.println("Grade C");
		}else if(re>50) {
			System.out.println("Grade D");
		}
	}
}
