package SWEA.D3;

import java.util.Scanner;

public class 정곤이의단조증가하는수 {

	public static void main(String[] args) {
		// Ai * Aj 를 곱합 값들을 배열에 넣고
		// 단조 증가인지 비교해서
		// max 값 찾기
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i < T + 1; i++) {
			int max = -1;
			int N = sc.nextInt();
			int[] arr = new int[N];
			// Ai ~An 값들 담기
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				arr[j] = input;
			}

			for (int k = 0; k < N - 1; k++) {
				String check = arr[k] * arr[k + 1] + "";
				// 단조 증가인지 비교
				boolean num = true;
				for (int c = 0; c < check.length() - 1; c++) {
					if (check.charAt(c) > check.charAt(c + 1)) {
						num = false;
						break;
					}
				}
				if (num) {
					max = Math.max(max, Integer.parseInt(check));
				}

			}
			System.out.printf("#%d %d\n", T, max);
		}

	}
}
