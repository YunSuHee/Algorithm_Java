package 수업_0808;

import java.util.Arrays;

public class List1_03_SelectionSort {
	static int[] nums = { 8, 123, 18, 321, 45, 418, 324, 64 };

	public static void main(String[] args) {

//		int[] nums = { 8, 123, 18, 321, 45, 418, 324, 64 };
		int N = nums.length;

		// 몇번 반복을 해야하나??
		// 마지막 자리는 정렬할 필요가 없음.
		for (int i = 0; i < N - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < N; j++) {
//				int minIdx = i; 매번 j가 돌때마다 minIdx i번째의 값으로 초기화가 되더라.
				// 현재 보고있는 j번째 값이 내가 가장 작다고 믿고 있는 값보다 작다면 갱신.
				if (nums[j] < nums[minIdx]) {
					minIdx = j;
				} // end if
			} // end for
				// minIdx에는 가장작은 값을 가리키는 (정렬이 되어있지 않은 친구들 중에)인덱스가 있다.
//			int tmp = nums[i];
//			nums[i] = nums[minIdx];
//			nums[minIdx] = tmp;

//			swap(nums, nums[i], nums[minIdx]);
//			swap(nums, i, minIdx);
			swap(i, minIdx);

		} // end for

		System.out.println(Arrays.toString(nums));
	}// main

//	static void swap(int[] nums, int a, int b) {
//		int tmp = a;
//		a = b;
//		b = tmp;
//	}
//	static void swap(int[] nums, int a, int b) {
//		int tmp = nums[a];
//		nums[a] = nums[b];
//		nums[b] = tmp;
//	}
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

}
