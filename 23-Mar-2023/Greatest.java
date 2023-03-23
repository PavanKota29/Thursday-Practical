//write a java program to take 3 numbers and find the greatest of 
//all the three numbers 

class Greatest{//Class Declaration 
	public static void main(String[] args) {
		int a=8,b=6,c=56;

		if(a>b && a>c){//Checking the a is greatest or not
			System.out.print("A is Greatest Number !!");
		}else if (b>c) {//Checking the b is greatest or not
			System.out.print("B is Greatest Number !!");
		}else{// if both the condition are false than c is greatest number
			System.out.print("C is Greatest Number !!");
		}
	}
}