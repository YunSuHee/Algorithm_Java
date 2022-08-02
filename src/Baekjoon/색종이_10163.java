package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 색종이_10163 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int MAX_NUMBER = 1001;
		int[][] paper = new int[MAX_NUMBER][MAX_NUMBER];

		for (int T = 1; T <= N; T++) {

			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();

			for (int i = x; i < x + width; i++) {
				for (int j = y; j < y + height; j++) {
					paper[i][j] = T;
				}
			}
		}
		//System.out.println(Arrays.deepToString(paper));


		for(int t=1; t<=N; t++) {
			int cnt = 0;
			for(int i=0; i<MAX_NUMBER; i++) {
				for (int j=0; j<MAX_NUMBER; j++) {
					if(paper[i][j] == t) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}

	}

}
