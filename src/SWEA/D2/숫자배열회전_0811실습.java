package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자배열회전_0811실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n * 4];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}


			for (int i = 0; i < 3; i++) {// 90,180,270 돌기
				for (int k = 0; k < n; k++) {
					for (int j = (i + 1) * n; j < (i + 2) * n; j++) {

						arr[k][j] = arr[n - 1 - (j % n)][k + (i * n)];
					}
				}
			}
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = n; j < n * 4; j++) {
					System.out.print(arr[i][j]);
					if (j % n == n - 1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}

}
