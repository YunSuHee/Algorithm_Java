import java.util.*;

public class Main {
	static int n;
	static int[][] apart;
	static boolean[][] check;

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
					result.add(bfs(i, j));
				}
			}
		}

		System.out.println(result.size());
		Collections.sort(result);
		for (int i : result) {
			System.out.println(i);
		}

	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		int result = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowx = now[0];
			int nowy = now[1];

			for (int i = 0; i < 4; i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];

				if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n && apart[nextx][nexty] == 1) {
					if (check[nextx][nexty])
						continue;

					check[nextx][nexty] = true;
					queue.add(new int[] { nextx, nexty });
					result++;
				}
			}
		}
		return result;
	}

}