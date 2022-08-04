package Baekjoon;

import java.util.Scanner;

public class 딱지놀이_14696 {

	public static void main(String[] args) {
		// A딱지와 B딱지 배열을 만든 후 입력받는 숫자를 배열 인덱스에 추가하여 마지막 인덱스부터 비교해 출력
		Scanner sc = new Scanner(System.in);

		int round = sc.nextInt();
		for (int i = 0; i < round; i++) {
			int aNum = sc.nextInt();
			int[] A = new int[5];
			for (int j = 0; j < aNum; j++) {
				A[sc.nextInt()]++;
			}
			int bNum = sc.nextInt();
			int[] B = new int[5];
			for (int j = 0; j < bNum; j++) {
				B[sc.nextInt()]++;
			}

			for (int j = 4; j >= 1; j--) {
				if (A[j] > B[j]) {
					System.out.println("A");
					break;
				} else if (A[j] < B[j]) {
					System.out.println("B");
					break;
				} else {
					if (j == 1) {
						System.out.println("D");
						break;

					}
				}
			}

		}

	}

}
