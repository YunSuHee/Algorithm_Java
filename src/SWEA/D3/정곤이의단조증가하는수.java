package SWEA.D3;

import java.util.ArrayList;
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
			ArrayList<Integer> danjo = new ArrayList<>();
			for (int j = 0; j < arr.length - 1; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					danjo.add(arr[j] * arr[k]);
				}
			}

			for (int k = 0; k < danjo.size(); k++) {
				String check = danjo.get(k) + "";
				// 단조 증가인지 비교
				boolean num = true;
				for (int c = 0; c < check.length() - 1; c++) {
					if (check.charAt(c) > check.charAt(c + 1)) {
						num = false;
						break;
					}
				}
				if (num) {
					max = Math.max(max, danjo.get(k));
				}

			}
			
			System.out.printf("#%d %d\n", i, max);
		}

	}
}
