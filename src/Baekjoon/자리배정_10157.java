package Baekjoon;

import java.util.Scanner;

public class 자리배정_10157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int col = sc.nextInt(); // 열
		int row = sc.nextInt(); // 행
		int target = sc.nextInt();
		int[][] concert = new int[row][col];

		int[] dx = { 1, 0, -1, 0 }; // 위, 오 ,아래, 왼
		int[] dy = { 0, 1, 0, -1 };
		int dir = 0; // 처음엔 위로

		int c = 0; // 시작점
		int r = 0;

		if (target <= row * col) {
			for (int i = 1; i < target; i++) {
				concert[c][r] = i;
				if (c + dx[dir] < 0 || r + dy[dir] < 0 || c + dx[dir] >= row || r + dy[dir] >= col  //범위가 벗어나는지, 해당 자리에 값이 있는지
						|| concert[c + dx[dir]][r + dy[dir]] != 0) {								// 범위가 벗어나는지 부터 체크를 해야한다. 만약 해당자리에 값이 있는지 부터 체크를 하면 벗어난 범위가 들어왔을때 indexerror가 발생한다. 
					dir++;
				}

				dir %= 4;
				c += dx[dir];
				r += dy[dir];

			}

			System.out.println((r + 1) + " " + (c + 1));
		} else {
			System.out.println(0);
		}
	}

}
