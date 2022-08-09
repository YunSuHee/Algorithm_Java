package SWEA.D2;

import java.util.Arrays;
import java.util.Scanner;

public class 최빈수구하기_0809실습 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			// 학생 점수를 담는 배열
			int[] score_arr = new int[101];

			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt();
				score_arr[score]++;
			}
			int index_value = 0;
			int index = 0;
			for (int i = 0; i <= 100; i++) {
				if (score_arr[i] >= index_value) {// 같으면 가장 큰 수를 출력하기 떄문에 크거나 같다라고 조건 담
					index_value = score_arr[i];
					index = i;

				}
			}

			System.out.printf("#%d %d\n", N, index);
		}
	}
}
