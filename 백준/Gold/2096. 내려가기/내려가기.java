import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] game = new int[n + 1][3];
		int[][] dpMax = new int[n + 1][3];
		int[][] dpMin = new int[n + 1][3];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				game[i][j] = sc.nextInt();
			}
		}

		dpMax[1][0] = game[1][0];
		dpMax[1][1] = game[1][1];
		dpMax[1][2] = game[1][2];

		dpMin[1][0] = game[1][0];
		dpMin[1][1] = game[1][1];
		dpMin[1][2] = game[1][2];

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]) + game[i][j];
					dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]) + game[i][j];
				} else if (j == 1) {
					dpMax[i][j] = Math.max(dpMax[i - 1][j - 1], Math.max(dpMax[i - 1][j], dpMax[i - 1][j + 1]))+ game[i][j];
					dpMin[i][j] = Math.min(dpMin[i - 1][j - 1], Math.min(dpMin[i - 1][j], dpMin[i - 1][j + 1]))+ game[i][j];
				} else if (j == 2) { 
					dpMax[i][j] = Math.max(dpMax[i - 1][j], dpMax[i - 1][j - 1]) + game[i][j];
					dpMin[i][j] = Math.min(dpMin[i - 1][j], dpMin[i - 1][j - 1]) + game[i][j];
				} 
			}

		}

		Arrays.sort(dpMax[n]);
		Arrays.sort(dpMin[n]);

		System.out.println(dpMax[n][2] + " " + dpMin[n][0]);

	}

}
