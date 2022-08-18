package Baekjoon;

import java.util.Scanner;

public class 수열_2559 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 날짜
		int k = sc.nextInt(); // 연속적인 날짜

		int[] temperature = new int[n];
		for (int i = 0; i < n; i++) {
			temperature[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i <= n - k; i++) { //시작 날짜
			int sum = 0;
			for (int j = 0; j < k; j++) { //연속적인 온도 더할 때
				sum += temperature[i + j];
			}
			if(i==0) max = sum; // max값이 음수 일 수도 있으니까
			max = Math.max(max, sum);
		}

		System.out.println(max);

	}

}
