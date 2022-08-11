package SWEA.D2;

import java.util.Scanner;

public class 달팽이숫자_0811실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int x = 0;
			int y = 0;
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			int dir = 0;
			for (int i = 1; i <= N * N; i++) {
				snail[x][y] = i;
				if (x + dx[dir] < 0 || x + dx[dir] >= N || y + dy[dir] < 0 || y + dy[dir] >= N
						|| snail[x + dx[dir]][y + dy[dir]] != 0) {
					dir = (dir + 1) % 4;
				}
				x += dx[dir];
				y += dy[dir];
			}
			
            System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j : snail[i]) {
					System.out.print(j + " ");
				}
				System.out.println();
			}

		}

	}

}
