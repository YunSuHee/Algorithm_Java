package temp;

import java.util.Arrays;
import java.util.Scanner;
//순열 

public class N과M1 {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] result;
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n]; // 어떤 값이 방문 했는지
		result = new int[m]; // 결과
		num = new int[n];
		for (int i = 1; i <= n; i++) {
			num[i - 1] = i;
		}

		perm(0);

	}

	static void perm(int idx) {
		// 기저 조건
		if (idx == m) {
			for (int i : result) {
				System.out.print(i + " ");
			}
			System.out.println();
			return; // 꼭 빠져 나오자
		}

		for (int i = 0; i < n; i++) { // 현재 idx에 들어갈 수 있는 값
			if (visited[i]) //이미 값이 있으면 pass
				continue;
			result[idx] = num[i]; //결과 값에 들어갈수 있는 값 넣고
			visited[i] = true; // 이미 방문
			perm(idx + 1);
			visited[i] = false; //조합과 다르게 이전 값들도 신경을 써야 하기 때문에 false로 초기화
		}
	}

}
