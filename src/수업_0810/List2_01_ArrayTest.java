package 수업_0810;

public class List2_01_ArrayTest {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6, }, { 7, 8, 9 } };

		int N = arr.length; // 3
		int M = arr[0].length; // 모든 행의 원소수가 같으므로 접근이 된다.

		// 1. 행우선순회
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 2. 행 역우선 순회
		for (int i = 0; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 3. 열 우선 순회
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();

		// 2. 행 역우선 순회
		for (int j = 0; j < N; j++) {
			for (int i = M - 1; i >= 0; i--) {
				System.out.printf("%3d", arr[i][j]);
			}
		}
		System.out.println();
	}

}
