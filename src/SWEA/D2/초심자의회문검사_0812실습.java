package SWEA.D2;

import java.util.Scanner;

public class 초심자의회문검사_0812실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int i = 1; i <= tc; i++) {
			String input = sc.next();
			StringBuffer sb = new StringBuffer(input);

			String reverse = sb.reverse().toString();

			if (input.equals(reverse)) {
				System.out.println("#" + i + " " + 1);
			} else {
				System.out.println("#" + i + " " + 0);
			}
		}

	}

}
