package SWEA.D2;

import java.util.Scanner;

public class 어디에단어가들어갈수있을까_0811실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[][] puzzle = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					puzzle[i][j] = sc.nextInt();
				}
			}

			int total = 0;
			for (int i = 0; i < n; i++) {
				int row = 0;
				int col = 0;
				for (int j = 0; j < n; j++) {
					//가로
					if (puzzle[i][j] == 1) {
						row++;
					} else if(row == k) { //puzzle[i][j]가 0이고 row 가 k 이면 total 추가
						total++;
						row =0; // 다음에 또 k 인 수가 나올수 있으니 0으로 초기화
					}else {
						row=0;
					}
					//세로
					if (puzzle[j][i] == 1) {
						col++;
					}else if(col == k) {
						total++;
						col =0;
					}else {
						col=0;
					}
					
				}
				if (row == k) total++;
				if(col == k) total++;

			}


			System.out.println("#" + t + " " + total);

		}
	}

}







