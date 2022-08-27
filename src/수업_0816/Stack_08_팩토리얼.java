package 수업_0816;

public class Stack_08_팩토리얼 {

	public static void main(String[] args) {
		System.out.println(fact(13));
	}// main
	
	
	public static long fact(int n) {
		//base case
		if(n <= 1) {
			return 1;
		}
		//recursive case
		return n * fact(n-1);
	}
}
