package Baekjoon;

import java.util.Scanner;

public class 팩토리얼0의개수_1676 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// 팩토리얼 규칙은 5의 배수마다 마지막에 0이 추가된다. 근데 5의 배수
		// 따라서 들어온 수 를 5로 나눈 몫이 정답이다.

		// for 문 도는 회수 => n/5 n까지 5의 배수가 몇번 나오는지
		int last = n / 5;
		int result = 0;
		for (int i = 1; i <= last; i++) {

			// 5의 배수중 끝자리가 5로 끝나는것중에 0이 두개가 추가 되는게 있어
			// 4*25일 경우 00이 추가

			// 4*n의 0 개수를 result에 추가
			String check = "" + 4 * 5 * i; // 만약 n이 26 이면 25*4를 체크 해야하니까
			int temp = 0;
			for (int j = 0; j < check.length(); j++) { // 0개수 세기
				if (check.charAt(j) == '0') {
					temp++;
				}
			}
			result += temp;
			

		}
		System.out.println(result);
	}
}
