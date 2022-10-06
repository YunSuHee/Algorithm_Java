import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int[] stair = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			stair[i]=sc.nextInt();
		}
		
		dp[1] = stair[1];
		if(n>1) dp[2] = stair[2]+stair[1];
		
		for(int i=3;i<=n;i++) {
			//1. 전칸과 전전칸을 밟고 올라오기
			//2. 전전칸 밟고 올라오기
			dp[i] = Math.max(stair[i-1]+dp[i-3], dp[i-2]) + stair[i];
		}
		
		
		System.out.println(dp[n]);

	}

}
