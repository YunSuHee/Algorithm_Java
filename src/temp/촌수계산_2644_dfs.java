package temp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산_2644_dfs {
	static int n, x, y, m;
	static int[][] people;
	static boolean[] check;
	static int result = 0;
	static int answer = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt() - 1;
		y = sc.nextInt() - 1;
		m = sc.nextInt();
		people = new int[n][n];

		for (int i = 0; i < m; i++) {
			int X = sc.nextInt() - 1;
			int Y = sc.nextInt() - 1;
			people[X][Y] = 1;
			people[Y][X] = 1;

		}

		check = new boolean[n];
		dfs(x);
		System.out.println(answer);

	}

	static void dfs(int x) {
		check[x] = true;

		if (x == y) {

			answer = result;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (people[x][i] == 1 && !check[i]) {

				check[i] = true;
				result += 1;
				dfs(i);
				result -= 1;

			}
		}
	}

}
