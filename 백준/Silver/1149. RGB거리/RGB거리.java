import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] rgb = new int[n + 1][3];
		int[][] dp = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();

			if (i == 1) {
				dp[1][0] = rgb[1][0];
				dp[1][1] = rgb[1][1];
				dp[1][2] = rgb[1][2];
			}
		}

		for (int i = 2; i <= n; i++) {
			for(int j=0;j<3;j++) {
				dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]) + rgb[i][j]; //전 dp 에서 현재 인덱스 제외한 인덱스들 중(rgb 세개니까 +1,+2 한후에 3으로 나눈 나머지 -> 배열 돌리기) 최소값 
			}
		}
		Arrays.sort(dp[n]);
		System.out.println(dp[n][0]);

	}

}
