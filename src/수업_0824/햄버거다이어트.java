package 수업_0824;

import java.util.Scanner;

public class 햄버거다이어트 {
	static int N, L;
	static int[] taste;
	static int[] K;
	static boolean[] check;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			taste = new int[N];
			K = new int[N];
			for(int i = 0; i < N; i++) {
				taste[i] = sc.nextInt();
				K[i] = sc.nextInt();
			}
			check = new boolean[N];
			ans = 0;
//			powerSet(0);
			solve(0,0,0);
			System.out.println("#" + tc + " " + ans);
		}
	}
	//idx번쨰 원소에 대해서 고를지 말지 기로.
	static void powerSet(int idx) {
		//재료의 갯수인 N까지 idx가 왔다면 모든 재료를 구한것.
		if( idx == N ) {
			//내가 고른 재료의 맛들의 합과 칼로리들의 합을 구하자.
			//더한 칼로리의 합이 L를 넘지 않는다면,,,
			//현재 맛의 점수와 ans 중 큰 값을 기억하자..
			int tSum = 0, kSum = 0;
			for(int i = 0; i < N; i++) {
				//i번째 재료를 고른거라면
				if( check[i] ) {
					tSum += taste[i];
					kSum += K[i];
				}
			}
			if( kSum <= L ) {
				ans = Math.max( ans, tSum );
			}
			return;
		}
		check[idx] = true;
		powerSet( idx + 1 );
		check[idx] = false;
		powerSet( idx + 1 );
	}
	
	//idx번째 원소를 더할지 말지 기로. 현재까지 더한 tSum, 현재까지 더한 kSum
	public static void solve(int idx, int tSum, int kSum) {
		//이미 칼로리가 오버 됐다면, 더이상의 재료를 골라볼 필요가 없다!!
		if( kSum > L )
			return;
		if( idx == N ) {
			if(kSum <= L)
				ans = Math.max(ans, tSum);
			return;
		}
		solve( idx + 1, tSum + taste[idx], kSum + K[idx] );
		solve( idx + 1, tSum, kSum );
	}
	
	
	
	
	
	
	
}
