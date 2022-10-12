import java.util.Scanner;

public class 비트박스 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N이... 10000000이라면? 메모리 얼마? 120M 메모리 ㅎㄷㄷ
		int N = sc.nextInt();
//		int[][] dp = new int[N][3];
//		dp[0][0] = sc.nextInt();
//		dp[0][1] = sc.nextInt();
//		dp[0][2] = sc.nextInt();
//		//이전에 선택한 비트는 선택할 수 없다.
//		for(int i = 1; i < N; i++) {
//			dp[i][0] = Math.max(dp[i-1][1], dp[i-1][2]) + sc.nextInt();
//			dp[i][1] = Math.max(dp[i-1][2], dp[i-1][0]) + sc.nextInt();
//			dp[i][2] = Math.max(dp[i-1][1], dp[i-1][0]) + sc.nextInt();
//		}
		int[][] dp = new int[2][3];
		dp[0][0] = sc.nextInt();
		dp[0][1] = sc.nextInt();
		dp[0][2] = sc.nextInt();
		for (int i = 1; i < N; i++) {
			//직전 최적해(0번줄)을 이용해 이번 최적해(1번줄)을 구하고
			dp[1][0] = Math.max(dp[0][1], dp[0][2]) + sc.nextInt();
			dp[1][1] = Math.max(dp[0][2], dp[0][0]) + sc.nextInt();
			dp[1][2] = Math.max(dp[0][1], dp[0][0]) + sc.nextInt();
			//다음 으로 넘어가기 전에 이번최적해를 직전최적해로 보내주자.
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
//		int max = Math.max(Math.max(dp[N-1][0], dp[N-1][1]), dp[N-1][2]);
		int max = Math.max(Math.max(dp[0][0], dp[0][1]), dp[0][2]);
		System.out.println(max);
	}
}
