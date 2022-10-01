package temp;

import java.util.*;

public class 단지번호붙이기_2667_dfs {
	static int n;
	static int[][] apart;
	static boolean[][] check;
	static int answer = 1;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();

		apart = new int[n][n];
		check = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < n; j++) {
				apart[i][j] = line.charAt(j) - '0';
			}
		}

		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 1 && !check[i][j]) {
					check[i][j] = true;
					dfs(i, j);
					result.add(answer);
					answer = 1;
				}
			}
		}

		System.out.println(result.size());
		Collections.sort(result);
		for (int i : result) {
			System.out.println(i);
		}

	}

	static void dfs(int x, int y) {
		
		for (int i = 0; i < 4; i++) {
			int nextx = x + dx[i];
			int nexty = y + dy[i]; 

			if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n && apart[nextx][nexty] == 1) {
				if (check[nextx][nexty])
					continue;
				check[nextx][nexty] = true;
				answer++;
				dfs(nextx,nexty);
			}
		}

	
	}

}
