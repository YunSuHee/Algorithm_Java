import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] schedule = new int[n][2];
		int[] dp = new int[n];
		
		for(int i=0; i<n;i++) {
			schedule[i][0] = sc.nextInt();
			schedule[i][1] = sc.nextInt();
		}
		
		if(schedule[n-1][0]==1) {
			dp[n-1] = schedule[n-1][1];
		}
		for(int i=0; i<n;i++) {
			if(schedule[i][0]<=n-i && dp[i]==0)dp[i] = schedule[i][1];
			for(int j= schedule[i][0]+i;j<n;j++) {
				if(schedule[j][0]>n-j) {
					continue;
				}else {
					
					dp[j] = Math.max(dp[j], Math.max(schedule[i][1], dp[i])+schedule[j][1]);
					
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(dp[n-1]);

	}

}
