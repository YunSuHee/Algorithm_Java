import java.util.Scanner;

public class 제로 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		dp[0] = 0;
		
		for(int i = 1; i <= N; i++) {
			dp[i] = dp[i-1] + 1;
			if( i % 5 == 0 )
				dp[i] = Math.min(dp[i], dp[i/5]+1);
			if( i % 3 == 0 )
				dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[N]);
	}
}