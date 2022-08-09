package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Flatten_0809실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int dump =sc.nextInt();
			int[] arr = new int[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				if(arr[99]-arr[0]==0) {
					break;
				}
				arr[99]=arr[99]-1;
				arr[0]=arr[0]+1;

			} Arrays.sort(arr);
			System.out.printf("#%d %d\n",t,arr[99]-arr[0]);
		}

	}

}
