package SWEA.D3;

import java.util.Scanner;

public class NQueen {
	static int n;
	static boolean[][] map;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			map = new boolean[n][n];
			result = 0;

			queen(0);
			System.out.println("#" + t + " " + result);

		}

	}

	static void queen(int r) {
		if (r == n) {
			result++;
			return;
		}

		for (int c = 0; c < n; c++) {
			if (isputQueen(r, c)) {
				map[r][c] = true;
				queen(r + 1);
				map[r][c] = false;

			}
		}

	}

	static boolean isputQueen(int r, int c) {
		int left = c;
		int right = c;

		for (int i = r - 1; i >= 0; i--) {
			left--;
			right++;
			if (map[i][c])
				return false; // 열 방향 체크
			if (left >= 0 && map[i][left])
				return false; // 왼쪽 대각선 체크
			if (right < n && map[i][right])
				return false; // 오른쪽 대각선 체크

		}
		return true;
	}

}
