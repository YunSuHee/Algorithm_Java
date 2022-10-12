import java.util.Arrays;
import java.util.Scanner;

public class 동전거스름돈문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();//목표금액
		int[] dp = new int[ money + 1 ];
		dp[0] = 0;
		for(int i = 1; i <= money; i++) {
			int min = 987654321;
			//1원 적은 부분문제에 1원을 추가하는 경우
			min = Math.min(min, dp[i-1] + 1);
			//4원 적은 부분문제에 4원을 추가하는 경우
			if( i >= 4 ) min = Math.min(min, dp[i-4] + 1);
			//6원 적은 부분문제에 6원을 추가하는 경우
			if( i >= 6 ) min = Math.min(min, dp[i-6] + 1);
			
			dp[i] = min;
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[money]);
		memo = new int[ money + 1 ];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		System.out.println(solve(money));
	}
	static int[] memo;
	static int solve(int money) {
		if(money < 0)
			return 987654321;
//		if( money == 0 )
//			return 0;
		if(memo[money] != -1)
			return memo[money];
		memo[money] = Math.min(Math.min(solve(money-1), solve(money-4)) ,solve(money-6))+1;
		return memo[money];
	}
}
