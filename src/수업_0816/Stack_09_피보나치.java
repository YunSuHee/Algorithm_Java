package 수업_0816; 

import java.util.Arrays;

public class Stack_09_피보나치 {
	//중복 쳌
	static int[] count  = new int[50];
	//기록용.
	static int[] memo = new int[50];
	static {
		memo[1] = 1;
	}
	
	public static void main(String[] args) {
//		System.out.println(fibo(40));
//		memo[1] = 1;
//		System.out.println(Arrays.toString(count));
		System.out.println(fibo2(49));
		
	}// main

	
	//메모이제이션 이라는 방법이다. 
	//기록을 해놓고 중복된 연산을 다시는 하지 않음. 추후 깊은 공부를 하실때 다시한번 들여다 볼것..
	public static int fibo2(int n) {
		if(n >= 2 && memo[n] == 0) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	
	
	
	
	public static int fibo(int n) {
		count[n]++;
		if (n <= 1)
			return n;
//		//fibo(0) == 0
//		if(n == 0) return 0;
//		//fibo(1) == 1
//		else if(n == 1)return 1;
		return fibo(n - 1) + fibo(n - 2);
	}
	
	
	
	
}
