package SWEA.D2;

import java.util.Scanner;

public class 중간평균값구하기_0809실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int max = 0;
			int min = 10001;
			double result = 0;
			for (int i = 0; i < 10; i++) {
				int temp = sc.nextInt();
				if (temp > max) {
					max = temp;
				}
				if (temp < min) {
					min = temp;
				}

				result += temp;
			}

			result = result - max - min;

			System.out.printf("#%d %d\n", t, Math.round(result / 8));

		}

	}

}
