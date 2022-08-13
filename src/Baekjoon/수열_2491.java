package Baekjoon;

import java.util.Scanner;

public class 수열_2491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 1;
		int increaseTemp = 1; // 증가한거면 arr[i-1] 부분도 체크 해줘야 하니까 시작이 1
		int decreaseTemp = 1;
		for (int i = 1; i < n; i++) {// 수열인지 비교하기
			if (arr[i - 1] <= arr[i]) { // 증가 수열인지 확인
				increaseTemp++;
			} else { // 증가가 아니면 증가템프 1으로 리셋
				increaseTemp = 1;
			}

			if (arr[i - 1] >= arr[i]) { // 감소 수열인지 확인
				decreaseTemp++;
			} else {
				decreaseTemp = 1;
			}

			max = Math.max(max, Math.max(increaseTemp, decreaseTemp));
		}

		System.out.println(max);

	}

}
