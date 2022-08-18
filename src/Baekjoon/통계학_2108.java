package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 통계학_2108 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result =0;
		int[] input = new int[n];
		
		for(int i=0;i<n;i++) {
			input[i]= sc.nextInt();
			result+=input[i];
		}
		Arrays.sort(input);
		//평균
		System.out.println(result/n);
		//중앙값
		System.out.println(input[n/2]);
		//최빈값
		
		//범위
		System.out.println(input[n-1]-input[0]);
		

	}

}
