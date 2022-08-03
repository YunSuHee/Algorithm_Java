package Baekjoon;

import java.util.Scanner;

public class 직사각형네개의합집합의면적구하기_2669 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] rectangle = new int[100][100]; // 평면 좌표 배열

		for (int T = 0; T < 4; T++) {
			int firstX = sc.nextInt(); 
			int firstY = sc.nextInt();
			int secondX = sc.nextInt();
			int secondY = sc.nextInt();
			for (int i = firstX; i < secondX; i++) {
				for (int j = firstY; j < secondY; j++) {
					rectangle[i][j] = 1; //직사각형이 위치해 있는 좌표에 1 저장
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (rectangle[i][j] == 1) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}

}
