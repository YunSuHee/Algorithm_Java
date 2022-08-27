package 수업_0808;

import java.util.Arrays;

public class List1_02_BubbleSort {
	public static void main(String[] args) {
		// 버블 정렬을 만들어보자.
		int[] nums = { 23, 17, 1997, 13, 7, 17, 77, 8 };

		int N = nums.length;

		// 오름차순으로 정렬을 해보자.
		// i는 실제로 정렬된 값의 위치
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				// 인접한 두수를 비교를 할건데 나와 내 다음 친구를 비교
				if (nums[j] > nums[j + 1]) {
					// swap
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
				}
			} // end for
		} // end for : 무슨 반복문이었는지...

		System.out.println(Arrays.toString(nums));

		// 다른방법

		for (int i = 0; i < N - 1; i++) {
			for (int j = 1; j < N - i; j++) {
				if (nums[j - 1] < nums[j]) {
					int tmp = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));

	}// main
}
