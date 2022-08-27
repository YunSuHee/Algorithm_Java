package 수업_0808;

public class List1_01_ArrayTest {
	public static void main(String[] args) {
		// 0에서부터 5까지 입력
//		int[] nums = new int[6];
//		nums[0] = 0;
//		nums[1] = 1;
//		nums[2] = 2;
//		nums[3] = 3;
//		nums[4] = 4;
//		nums[5] = 5;

		// 초기화 가능 : 값을 알고 있다면
		int[] nums = { 0, 1, 2, 3, 4, 5 };

		// 1. 정방향 순회
		// 1-1. 일반 적인 포문 사용
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}

		// 1-2. foreach : 단점으로는 값을 복사해서 사용한다.
		for (int i : nums) {
			System.out.println(i);
			// 지금 상황에서는 아래와 같이 작성이 가능하지만 쓰지 않기
//			System.out.println(nums[i]);
		}

		// 2. 역방향 순회
		// 2-1. 마지막 인덱스부터 0까지 거꾸로 반복문순회
		for (int i = nums.length - 1; i >= 0; i--) {
			System.out.println(nums[i]);
		}

		// 2-2. 인덱스를 조정해서 순회
		int N = nums.length;
		for (int i = 0; i < N; i++) {
			// 끝 인덱스에서 i값을 증가시키면서 값을 접근
			System.out.println(nums[N - 1 - i]);
		}

	}
}
