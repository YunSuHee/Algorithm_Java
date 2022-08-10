package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class Sum_0810실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int[][] arr = new int[100][100];
			int t = sc.nextInt();
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int maxRow = 0;
			int maxCol = 0;
			int leftDiagonal = 0;
			int rightDiagonal = 0;

			for (int i = 0; i < 100; i++) {
				int rowTemp = 0;
				int colTemp = 0;
				for (int j = 0; j < 100; j++) {
					rowTemp += arr[i][j]; // 행 추가
					colTemp += arr[j][i]; // 열 추가
					if (i == j)
						leftDiagonal += arr[i][j]; // 왼쪽 대각선에 추가
					if (i + j == 99)
						rightDiagonal += arr[i][j]; // 오른쪽 대각선에 추가
				}
				if (rowTemp > maxRow)
					maxRow = rowTemp;
				if (colTemp > maxCol)
					maxCol = colTemp;
			}

			int[] max = { maxRow, maxCol, leftDiagonal, rightDiagonal };
			Arrays.sort(max);
			System.out.println("#"+t+" "+max[3]);

		}

	}

}
