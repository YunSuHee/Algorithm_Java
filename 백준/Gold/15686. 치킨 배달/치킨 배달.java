import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// 조합으로 치킨집을 고르기
	// 2차 배열을 돌면서 1일때 가까운 치킨집이랑 거리 구하기
	// 가장 작은 값 출력

	static int min = 1000000;
	static int[][] city;
	static int n;
	static ArrayList<int[]> chicken; // 치킨집 위치

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		city = new int[n][n];

		// 도시 입력
		int cntTwo = 0;
		chicken = new ArrayList<int[]>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				int[] arr = new int[2];
				arr[0] = i;
				arr[1] = j;
				city[i][j] = temp;
				if (city[i][j] == 2) { // 치킨집일때 치킨집 위치와 개수
					cntTwo++;
					chicken.add(arr);
				}
			}
		}

		// 조합 만들 배열 cntTwo 개의 배열 -> chicken arraylist 인덱스 값으로 배열 하기
		int[] combArr = new int[cntTwo];
		boolean[] visited = new boolean[cntTwo];
		for (int i = 0; i < cntTwo; i++) {
			combArr[i] = i; // comArr 의 값이 chicken arraylist의 인덱스 값이 됨!
		}
		// combination -> cntTwo개 중 m개 고르기

		combination(combArr, visited, 0, m, m);

		System.out.println(min);

	}

	static void combination(int[] combArr, boolean[] visited, int depth, int r, int finalR) {
		if (r == 0) {
			result(combArr, visited, finalR); // r은 계속 하나씩 줄어드니까 finalR
			return;
		}

		if (depth == combArr.length) {
			return;
		}

		visited[depth] = true;
		combination(combArr, visited, depth + 1, r - 1, finalR);

		visited[depth] = false;
		combination(combArr, visited, depth + 1, r, finalR);

	}

	static void result(int[] comArr, boolean[] visited, int r) { //조합마다 min 값 찾아서 update
		int[] finalChiken = new int[r];
		int index = 0;
		for (int i = 0; i < comArr.length; i++) {
			if (visited[i]) {
				finalChiken[index++] = comArr[i];
			}
		}

		// n*n 행렬 돌면서 1일떄 m 개의 배열 위치 차 구해서 작은거 저장
		int tempcheckMin = 0; // 최종 가장 가까운 거리랑 비교할 min
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (city[i][j] == 1) {
					// finalChiken집 위치들중 가장 가까운 곳 저장
					int tempRMin = 10000;// r개 위치중 가장 가까운 위치
					for (int k = 0; k < r; k++) {
						int x = chicken.get(finalChiken[k])[0]; //치킨집 x 좌표
						int y = chicken.get(finalChiken[k])[1]; //치킨집 y 좌표

						int distance = Math.abs(i - x) + Math.abs(j - y); // 거리
						if (distance < tempRMin) {
							tempRMin = distance;
						}
					}
					tempcheckMin += tempRMin; 
				}
			}
		}

		if (min > tempcheckMin) {
			min = tempcheckMin;
		}

	}

}
