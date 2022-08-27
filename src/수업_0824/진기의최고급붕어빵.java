package 수업_0824;

import java.util.Scanner;

public class 진기의최고급붕어빵 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();//손님의 수
			int M = sc.nextInt();//붕어빵 쿨타임
			int K = sc.nextInt();//1회 붕어빵 생산량
			
			int[] time = new int[11112];
			//사람의 수만큼 도착시간을 입력.
			for(int i = 0; i < N; i++) {
				int n = sc.nextInt();//도착시간
				time[n]++;
			}
			int bread = 0;
			String ans = "Possible";
			for(int i = 0; i < time.length; i++) {
				//빵만들고 -> 현재 시간이 M으로 나눠 떨어진다면 생산!
				if( i != 0 &&  i % M == 0 )
					bread += K;
				
				//사람수만큼 빵 주고  i시간에 도착한 사람의 수인 time[i]만큼의 빵을 제거
				bread -= time[i];
				
				//어라.. 빵을 줬더니 빵이 음수가 됐네? 그럼 Impossible 
				if( bread < 0 ) {
					ans = "Impossible";
					break;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}






