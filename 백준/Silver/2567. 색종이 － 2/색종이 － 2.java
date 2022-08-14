import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] paper = new int[100][100];

		for (int i = 0; i < n; i++) { // 색종이 부분 1로 만들기
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int cnt = 0;
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {// 사방탐색 하여 0 개수 체크
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x > 99 || y > 99) { // 처음부터 자연수가 들어오기 때문에 x,y가 음수일 경우는 없다
							cnt++;
						}else if (paper[x][y] == 0) {
							cnt++;
						}
					}
				}
			}
		}

		System.out.println(cnt);


	}

}
