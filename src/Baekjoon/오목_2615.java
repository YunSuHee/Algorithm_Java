package Baekjoon;

import java.util.Scanner;

public class 오목_2615 {

	static int[][] omog = new int[19][19];

	// 북동, 우, 남동, 하
	static int[] dx = { -1, 0, 1, 1 };
	static int[] dy = { 1, 1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				omog[i][j] = sc.nextInt(); // 검은색 : 1 흰색 : 2
			}
		}
		int check = 0; // 승부가 안났을때
		// r
		out: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				if (omog[i][j] != 0) { // 오목이 있을 때
					// 팔방 탐색
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && omog[nx][ny] == omog[i][j]) {

							int cnt = 2; // i,j (1개) nx, ny (1개)
							int omogCnt = omogNum(nx, ny, k, cnt);
							if (omogCnt == 5) {
								// 오목인 6 개인 경우 두번째 위치가 시작위치여서 5개만 카운트 되는 반례를 거르기 위해
								if (check(i, j, k)) {
									System.out.println(omog[i][j]); // 오목이 6
									System.out.println((i + 1) + " " + (j + 1));
									check = 1;
									break out;
								}
							}
						}
					}

				}
			}
		}
		if (check == 0) {
			System.out.println(0);
		}

	}

	static int omogNum(int i, int j, int k, int cnt) {
		int backI = i;
		int backJ = j;
		int totalCnt = cnt;
		while (totalCnt <= 5) {
			int nx = backI + dx[k];
			int ny = backJ + dy[k];
			if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && omog[nx][ny] == omog[backI][backJ]) {
				totalCnt++;
				backI = nx;
				backJ = ny;
			} else {
				break;
			}

		}
		return totalCnt;
	}

	static boolean check(int i, int j, int k) {
		int nx = i + dx[k] * -1; // 반대 방향 check
		int ny = j + dy[k] * -1;

		if (nx >= 0 && ny >= 0 && nx < 19 && ny < 19 && omog[nx][ny] == omog[i][j]) {
			return false;
		}
		return true;
	}

}
