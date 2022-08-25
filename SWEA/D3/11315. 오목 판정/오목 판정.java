import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] dx = { 0, 1, 1, 1 }; // 오른쪽, 아래, 남서, 남동
	static int[] dy = { 1, 0, -1, 1 };
	static char[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			arr = new char[n][n];
			boolean status = false;

			// 입력받기
			for (int i = 0; i < n; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = line.charAt(j);
				}
			}

			out: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// j
					if (arr[i][j] == 'o') {
						status = check(i, j, n);
						if (status) {
							break out;
						}
					}

				}
			}

			if (status) {

				System.out.println("#" + t + " YES");
			} else {
				System.out.println("#" + t + " NO");
			}

		}

	}

	static boolean check(int x, int y, int n) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			int cnt = 1;
			while (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 'o') {
				nx += dx[i];
				ny += dy[i];
				cnt++;
			}

			if (cnt >= 5) {
//				nx = x - dx[i];
//				ny = y - dy[i];
//				if (nx < 0 || nx >= n || ny < 0 || ny >= n || arr[nx][ny] != 'o') {
//
//					return true;
//				}
				return true;
			}
		}
		return false;
	}

}