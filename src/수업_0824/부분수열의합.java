package 수업_0824;

import java.util.Scanner;

public class 부분수열의합 {
	static int N, K;
	static boolean[] check;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			check = new boolean[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			ans = 0;
			powerSet(0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	static int ans = 0;
	static void powerSet(int idx) {
		//부분집합이 다 골라짐ㅇㅇ
		if( idx == N ) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				//check된 숫자를 더한다.
				if( check[i] ) {
					sum += arr[i];
				}
			}
			if( K == sum ) {
				//여기가 OK인데 여기 들어온 갯수를 세면 정답의 경우의 수
				ans++;
			}
			return;
		}
		check[idx] = true; //idx번째 원소를 고름.
		powerSet(idx + 1);
		check[idx] = false; //idx번째  원소를 안고름ㅋ
		powerSet(idx + 1);
	}
}
