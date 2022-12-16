import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static String[][] war;
	static boolean[][] check;
	static int resultw, resultb = 0;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		sc.nextLine();
		war = new String[n][m];

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < m; j++) {
				war[i][j] = line.charAt(j) + "";
			}
		}

		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (("W").equals(war[i][j]) && !check[i][j]) {
					bfs(i, j, "W");
				} else if (("B").equals(war[i][j]) && !check[i][j]) {
					bfs(i, j, "B");
				}
			}
		}

		System.out.println(resultw + " " + resultb);

	}

	static void bfs(int x, int y, String team) {

		int count = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		check[x][y] = true;

		while (!queue.isEmpty()) {

			int[] now = queue.poll();
			int X = now[0];
			int Y = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = X + dx[i];
				int ny = Y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && team.equals(war[nx][ny])) {

					if (check[nx][ny])
						continue;
					check[nx][ny] = true;
					queue.add(new int[] { nx, ny });
					count++;

				}
			}
		}

		if (team.equals("W")) {
			resultw += count * count;
		} else {
			resultb += count * count;
		}
	}

}
