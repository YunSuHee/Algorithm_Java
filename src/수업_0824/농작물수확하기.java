package 수업_0824;

import java.util.Scanner;

public class 농작물수확하기{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j) - '0';//'1' '0'
				}
			}
		}
	}
}