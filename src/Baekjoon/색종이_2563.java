package Baekjoon;

import java.util.Scanner;

public class 색종이_2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] paper = new int[101][101];
		int maxX = 0;
		int maxY = 0;
		int result = 0;

		// paper arr에 값 넣기
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (x > maxX)
				maxX = x;
			if (y > maxY)
				maxY = y;

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}

		}
		for (int j = 0; j <= maxX + 10; j++) {
			for (int k = 0; k <= maxY + 10; k++) {
				result += paper[j][k];
			}
		}
		System.out.println(result);

	}

}
