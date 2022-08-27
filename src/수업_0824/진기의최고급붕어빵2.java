package 수업_0824;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//손님의 수
			int M = sc.nextInt();//붕어빵 쿨타임
			int K = sc.nextInt();//붕어빵 1회 생산량
			
			int[] person = new int[N];
			for(int i = 0; i < N; i++)
				person[i] = sc.nextInt();
			//도착한 순으로 줄을 스자..
			Arrays.sort(person);
			String ans = "Possible";
			for(int i = 0; i < N; i++) {
				//내가 도착한 시간 person[i]
				//내가 도착할 때 까지 만들어진 빵
				int bread = (person[i] / M) * K;
				if( bread - 1 - i < 0 ) {
					ans = "Impossible";
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
