import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		int[][] dice = new int[n][6];
		int[] removeValue = { 5, 3, 4, 1, 2, 0 }; // 맨위 맨아래 값 위치 removeValue[0] =5 와 같은.. 0과 5 짝궁/ 1과 3 짝궁/ 2와 4 짝궁
		// 입력
		for (int t = 0; t < n; t++) {
			for (int i = 0; i < 6; i++) {
				dice[t][i] = sc.nextInt();
			}
		}
		for (int i = 1; i <= 6; i++) { // 맨위에가 1일때부터 5일때까지
			// i인 위치를 찾고 그 위치 반대방향과 i인 위치의 arr를 0으로 해주고 arr의 맥스 값을 result에 더해
			int temp = 0; // i일떄 최대 값 임시 저장
			int check =i;
			for (int j = 0; j < n; j++) {
				int[] findMax = dice[j].clone(); // 깊은 복사
				for (int k = 0; k < 6; k++) {
					if (dice[j][k] == check) {
						// findMax로 복사 안하고 dice에다 하면 값을 밑에 코드에서 0으로 초기화 해주면 i가 다른 값이 되면 원래 배열이 아닌 훼손된 배열
						findMax[k] = 0; // 그 값 0
						check = dice[j][removeValue[k]]; // 맞닿는 면은 계속 update가 된다!!!!!!!!그리고 값이야!!!!!!!!!!!!!! 이거 때매 오류!!!!!!!! 문제좀 읽어라
						findMax[removeValue[k]] = 0; // 반대 방향 0

						break;
					}
				}
				// dice[j]의 max 찾기
				Arrays.sort(findMax);
				temp += findMax[5];

			}
			// i가 1~5인거 완전 탐색후 가장 큰 값
			max = Math.max(max, temp);
		}

		System.out.println(max);
	}
}