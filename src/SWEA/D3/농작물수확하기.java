package SWEA.D3;

import java.util.Scanner;

public class 농작물수확하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			int[][] field = new int[n][n];
			// 입력
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < n; j++) {

					field[i][j] = Integer.parseInt("" + line.charAt(j));
				}
			}

			int first = n / 2;
			int start = 0;
			int end = n - 1;
			int result = 0;
			for (int i = 0; i < n; i++) {
				int interval = Math.abs(first - i);
				int x = Math.abs(start + interval);
				int y = Math.abs(end - interval);
				for (int j = x; j <= y; j++) {
					result += field[i][j];
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
