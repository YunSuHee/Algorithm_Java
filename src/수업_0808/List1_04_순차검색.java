package 수업_0808;

import java.util.Arrays;

public class List1_04_순차검색 {
	static int[] nums = { 8, 123, 18, 321, 45, 418, 324, 64 };

	public static void main(String[] args) {
		System.out.println(searchForNoSort(45));
		System.out.println(searchWhileNoSort(45));
		
		Arrays.sort(nums);
		
		System.out.println(searchForSort(44));
		System.out.println(searchWhileSort(44));
		
		
	}// main

	// 찾았다. 못찾았다 가 필요하면 boolean
	// 찾았으면 어디에서 찾았는지가 중요하면 int
	static boolean searchForNoSort(int key) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == key)
				return true;
		}
		// 서울 7반 임혜진
		return false;
	}

	// while문으로 작성을 해보자.
	static boolean searchWhileNoSort(int key) {
		int idx = 0;
		while (idx < nums.length) {
			if (nums[idx++] == key) {
				return true;
			}
		}
		return false;
	}
	
	//마음의 숙제 //서울 7 반 박수민
	static int searchForSort(int key) {
		
		return -1;
	}
	//마음의 숙제
	static int searchWhileSort(int key) {
		
		return -1;
	}

}
