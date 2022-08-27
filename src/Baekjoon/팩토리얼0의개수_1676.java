package Baekjoon;

import java.util.Scanner;

public class 팩토리얼0의개수_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 팩토리얼 규칙은 5의 배수마다 마지막에 0이 추가된다.
		// 따라서 들어온 수 를 5로 나눈 몫이 정답이다.

		// for 문 도는 회수 => n/5+1
		int last = n / 5 + 1;
		int result = 0;
		for (int i = 0; i < last; i++) {
			String check = "" + (i * 5) * (i * 5 - 1);
			// long 값의 0의 개수 더하기
			int sum = 0;
			for (int j = 0; j < check.length(); j++) {
				if (check.charAt(j) == 0) {
					sum++;
				}
			}
			result += sum;
		}
		System.out.println(result);
	}
}
