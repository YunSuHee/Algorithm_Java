import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, r, g, b, rg;
	static boolean[][] check;
	static String[][] rgb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		check = new boolean[n][n];
		rgb = new String[n][n];
		sc.nextLine();

		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			rgb[i] = line.split("");

		}
		r = 0;
		g = 0;
		b = 0;
		rg = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j]) {
					continue;
				}
				bfs(i, j);
			}
		}
		// check 초기화
		check = new boolean[n][n];
		// System.out.println(Arrays.deepToString(check));
		//System.out.println(r + "" + g + "" + b + "" + rg);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i][j] || "B".equals(rgb[i][j])) {
					continue;
				}
				rg += 1;
				bfsrg(i, j);
			}
		}
		//System.out.println(r + " " + g + " " + b + " " + rg);
		System.out.println((r + g + b) + " " + (rg + b));

	}

	private static void bfs(int i, int j) {
		check[i][j] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		String color = rgb[i][j];

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny] && color.equals(rgb[nx][ny])) {
					check[nx][ny] = true;
					queue.add(new int[] { nx, ny });
				}
			}

		}

		if (color.equals("R")) {
			r += 1;
		} else if (color.equals("G")) {
			g += 1;
		} else if (color.equals("B")) {
			b += 1;
		}

	}

	private static void bfsrg(int i, int j) {
		check[i][j] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny]) {
					if (!"B".equals(rgb[nx][ny])) {

						check[nx][ny] = true;
						queue.add(new int[] { nx, ny });
					}
				}
			}

		}

	}

}