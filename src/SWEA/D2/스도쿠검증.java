package swea;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 스도쿠검증 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int[][] sdoko = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sdoko[i][j] = sc.nextInt();
				}

			}
			// System.out.println(Arrays.deepToString(sdoko));
			// 가로 세로줄 확인
			int answer = 1;
			int[] temp_row = new int[10];
			int[] temp_col = new int[10];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) { // array.contains()
					temp_row[sdoko[i][j]] = 1;
					temp_col[sdoko[j][i]] = 1;
				}
				
				for(int a=1;a<=9;a++) {
					if(temp_row[a] ==0 || temp_col[a] ==0) {
						answer = 0;
						break;
					}
				}
//				if (Arrays.asList(temp_row).contains(0) || Arrays.asList(temp_col).contains(0)) {
//					answer = 0;
//					break;
//				}
				// 배열 다시 초기화
				temp_row = new int[10];
				temp_col = new int[10];
			}

			// 3*3 작은 격자중 가운데 부분을 for문으로 돌고 dx dy 로 검사
			int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1, 0 };
			int[] dy = { -1, 0, 1, -1, 1, -1, 1, 0, 0 };
			int[] temp = new int[10];
			if (answer == 1) {
				for (int i = 1; i <= 7; i += 3) {
					for (int j = 1; j <= 7; j += 3) {
						// 3*3격자 가운데 부분에서 사방으로 가는거 검사
						for (int c = 0; c < 9; c++) {
							int x = i + dx[c];
							int y = j + dy[c];
							temp[sdoko[x][y]] = 1;
						}
						
						for(int a=1;a<=9;a++) {
							if(temp[a] == 0) {
								answer = 0;
								break;
							}
						}
//						if (Arrays.asList(temp).contains(0)) {
//							answer = 0;
//							break;
//						}
						temp = new int[10];
					}
				}
			}
			System.out.println("#" + t + " " + answer);

		}
	}

}
