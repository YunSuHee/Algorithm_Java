
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] jump = new int[n][n];
        long[][] dp = new long[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                jump[i][j] = sc.nextInt();
            }
        }
        dp[0][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int next = jump[i][j];
                if(next == 0) break;
                if(i+next<n) dp[i+next][j] += dp[i][j];
                if(j+next<n) dp[i][j+next] += dp[i][j];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
