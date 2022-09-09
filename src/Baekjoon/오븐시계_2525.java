package Baekjoon;

import java.util.Scanner;

public class 오븐시계_2525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int c = sc.nextInt();

		if (b + c < 60) {
			System.out.println(a + " " + (b + c));
		} else {
			int plus_a = (b + c) / 60;
			int plus_b = (b + c) % 60;
			int hour = a + plus_a;
			if (hour > 23) {
				hour = hour % 24;
			}
			System.out.println(hour + " " + plus_b);
		}

	}

}
