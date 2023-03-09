
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] jump = new int[n][n];

        //dp
        // 경로의 개수는 2^63-1보다 작거나 같으니 long타입
        long[][] dp = new long[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                jump[i][j] = sc.nextInt();
            }
        }
        //출발지 값 지정
        dp[0][0] = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                //점프할 수 있는 거리
                int next = jump[i][j];

                //JUMP 했을때 도착지인 경우
                if(next == 0) break;

                //아래로 내려가는 경우
                if(i+next<n) dp[i+next][j] += dp[i][j];
                //오른쪽으로 내려가는 경우
                if(j+next<n) dp[i][j+next] += dp[i][j];

            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
