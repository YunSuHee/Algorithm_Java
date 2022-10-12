package Baekjoon;

import java.util.Scanner;

public class ㅇ123더하기_9095 {
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();

			dp = new int[n];

			if (n > 3) {
				dp[0] = 1;
				dp[1] = 2;
				dp[2] = 4;

				for (int i = 3; i < n; i++) {
					dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
				}
				System.out.println(dp[n - 1]);

			} else {
				switch (n) {
				case 1:
					System.out.println(1);
					break;
				case 2:
					System.out.println(2);
					break;
				case 3:
					System.out.println(4);
					break;
				}

			}
		}

	}

}
