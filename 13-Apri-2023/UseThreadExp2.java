package Pack1;
/*3. Create two thread.one thread is finding average of first 50 numbers 
 * and other thread is printing square of number store in array arr={10,15,20,25,30}.*/

class Mythread5 extends Thread{//extending the thread class
	public void run() {//Run method
		int num=0;
		int c=50;
		for(int i=1;i<=c;i++) {
			num=num+i;
		}
		double re=(double)(num/c);//finding the avg of first 50 numbers 
		System.out.println("Average of First 50 Number is "+re);
	}
}

class Mythread6 extends Thread{//extending the thread class
	public void run() {//Run method
		int[] arr= {10,15,20,25,30};//given array
		System.out.println("Printing the square of Given Array Elements:");
		for(int i:arr) {
			System.out.println(i*i);//printing square of given array element
		}
	}
}
public class UseThreadExp2 {
	public static void main(String[] args) {
		Mythread5 m1=new Mythread5();//creating obj
		Mythread6 m2=new Mythread6();//creating obj
		m1.start();//using start() run the thread
		m2.start();//using start() run the thread
	}
}
