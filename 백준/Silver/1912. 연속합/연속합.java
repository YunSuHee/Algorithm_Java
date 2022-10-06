import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] seq = new int[n];
		for(int i=0;i<n;i++) {
			seq[i]= sc.nextInt();
		}
		
		int[] dp = new int[n];
		dp[0]= seq[0];
		int max = dp[0];
		
		for(int i=1;i<n;i++) {
			dp[i] = Math.max(seq[i], dp[i-1]+seq[i]);
			
			//반례 -3 5
//			if(dp[i-1]+seq[i]<=0) {
//				dp[i] = seq[i];
//			}else {
//				dp[i] = dp[i-1]+seq[i];
//			}
			if(dp[i]>max) max = dp[i];
		}
		
		System.out.println(max);

	}

}
