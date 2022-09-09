package Baekjoon;

import java.util.Scanner;

public class 오목이길수있을까_16955 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] omog = new char[10][10];

		// 입력
		for (int i = 0; i < 10; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 10; j++) {
				omog[i][j] = line.charAt(j);
			}
		}
//		int[] dx = { 1, 1, 0, 1 };
//		int[] dy = { 0, 1, 1, -1 };
//		
		int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
		//사방 탐색이 안되는 경우  ......XXXX 이런 경우 떄문에.. 내가 처음이 x 일떄 if문을 쓰는거여서,,, 처음이 .일수도... 와우

		int countX = 1;
		int countDot = 0;
		boolean goo = false; // 구사가과 이길경우
		
		out: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (omog[i][j] == 'X') {
					for (int k = 0; k < 8; k++) { // 4방향 탐색
						int nx = i + dx[k];
						int ny = j + dy[k];
						int cnt = 0;
						while (nx < 10 && nx >= 0 && ny < 10 && ny >= 0 && cnt < 4) { // 범위에서 벗어나는지

							if (omog[nx][ny] == '.') {
								countDot++;
							} else if (omog[nx][ny] == 'X') {
								countX++;
							}
							cnt++;
							nx += dx[k];
							ny += dy[k];

						}
						if (countDot == 1 && countX == 4) { // 구사과가 이길때
							System.out.println(1);
							goo = true;
							break out;
						} else { // 구사과가 이기지 않을때 count는 초기화
							countX = 1;
							countDot = 0;
						}

					}

				}
			}
		}
		if (!goo) {// 구사과가 false 면 큐브러버가 이기는 경우

			System.out.println(0);
		}

	}

}
