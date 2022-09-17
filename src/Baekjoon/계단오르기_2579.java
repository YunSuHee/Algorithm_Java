package Baekjoon;

import java.util.Scanner;

public class 계단오르기_2579 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		int[] floor = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			floor[i] = sc.nextInt();
		}

		// dp의 1,2칸 채우기
		dp[1] = floor[1];

		if (n >= 2) {// n이 1일 수도 있으니
			dp[2] = floor[1] + floor[2];
		}

		// 계단 올라올 수 있는 경우의 수 2가지
		// 1. 전전칸 밟고 오기 (-2칸)
		// 2. 전전전칸 밟고, 전칸 밟고 오기(-3칸, -1칸)
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + floor[i - 1], dp[i - 2]) + floor[i]; // 올라올 수 있는 경우의 수 2가지 중 큰 값 + 현재 값
		}

		System.out.println(dp[n]);

	}

}
