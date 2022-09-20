import java.util.Scanner;

public class Main {
	static int n;
	static int result = 0;
	static int[][] home;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		home = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				home[i][j] = sc.nextInt();
			}
		}
		// 1 가로 2 세로 3 대각선
		pipe(1, 0, 1);
		System.out.println(result);

	}

	static void pipe(int dir, int r, int c) {

		if (r >= n || c >= n || home[r][c] == 1) {
			return;
		}

		if (dir == 3 && (home[r][c - 1] == 1 || home[r - 1][c] == 1)) {
			return;
		}
		if (r == n - 1 && c == n - 1) {
			result++;
			return;
		}

		if (dir == 1) {
			pipe(1, r, c + 1);
			pipe(3, r + 1, c + 1);
		} else if (dir == 2) {
			pipe(2, r + 1, c);
			pipe(3, r + 1, c + 1);
		} else if (dir == 3) {
			pipe(1, r, c + 1);
			pipe(2, r + 1, c);
			pipe(3, r + 1, c + 1);
		}
	}

}
