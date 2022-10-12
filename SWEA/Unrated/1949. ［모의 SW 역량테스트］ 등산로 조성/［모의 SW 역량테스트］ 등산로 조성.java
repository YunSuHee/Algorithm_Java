import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class inputQ {
	int x, y, value, iscut, cnt;
	boolean[][] check;

	public inputQ(int x, int y, int value, int iscut, int cnt, boolean[][] check) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.iscut = iscut;
		this.cnt = cnt;
		this.check = check;
	}

}

public class Solution {
	static int n, k, max;
	static int[][] mt;
	// static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			n = sc.nextInt();
			k = sc.nextInt();
			max = Integer.MIN_VALUE;
			mt = new int[n][n];

			int highest = 0;

			// 봉우리 값 입력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int input = sc.nextInt();
					mt[i][j] = input;
					if (highest < input)
						highest = input; // 가장 높은 봉우리 값 찾기
				}
			}

			// 최고 봉우리 위치 찾기
			int[][] top = new int[5][2]; // 봉우리의 x,y 좌표 높은 봉우리는 최대 5개이다.
			int tempIdx = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mt[i][j] == highest) {
						top[tempIdx][0] = i;
						top[tempIdx][1] = j;
						tempIdx++;
					}

				}
			}

			// 최고 봉우리에서 bfs
			for (int i = 0; i < tempIdx; i++) {
				int x = top[i][0];
				int y = top[i][1];

				boolean[][] check = new boolean[n][n]; // 새로운 봉우리마다 check 초기화
				bfs(x, y, mt[x][y], 0, 1, check); // x좌표 , y좌표, 현재 좌표의 봉우리 높이, k 만큼 깎았는지 (깎았으면 1 , 안깎았으면 0), cnt ,방문했는지
													// check

			}

			System.out.println("#" + t + " " + max);
		}
	}

	static void bfs(int x, int y, int value, int cut, int cnt, boolean[][] check) {
		// Queue<int[]> queue = new LinkedList<>();
		Queue<inputQ> queue = new LinkedList<>();
		check[x][y] = true;
		queue.add(new inputQ(x, y, value, cut, cnt, check));

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			inputQ info = queue.poll();
			int nx = info.x;
			int ny = info.y;
			int nowheight = info.value;
			int iscut = info.iscut;
			int count = info.cnt;
			boolean[][] ischeck = info.check;
			max = Math.max(max, count);
			// System.out.println(info.x+" "+info.y+" "+info.value+" "+info.iscut+"
			// "+info.cnt +Arrays.deepToString(info.check));

			// int isStop = 0; //queue에 하나도 추가가 안되면 더이상 이동할 곳이 없으니 멈춰야 함
			for (int i = 0; i < 4; i++) {// 사방 탐색
				int nextx = nx + dx[i];
				int nexty = ny + dy[i];

				// 다음 값이 범위 안에 있는 지 + 이미 방문 안한 곳인지 check
				if (nextx >= 0 && nextx < n && nexty >= 0 && nexty < n && !ischeck[nextx][nexty]) {

					boolean[][] newvisit = new boolean[n][n];
					for (int j = 0; j < n; j++)
						newvisit[j] = ischeck[j].clone();

					// 조건 성립하는지 check
					// 현재꺼보다 낮은 지형인지
					newvisit[nextx][nexty] = true; // 방문 처리

					if (nowheight > mt[nextx][nexty]) {
						queue.add(new inputQ(nextx, nexty, mt[nextx][nexty], iscut, count + 1, newvisit));

						// ischeck[nextx][nexty] = true; //방문 처리
						// queue.add(new inputQ(nextx,nexty,mt[nextx][nexty],iscut,count+1,ischeck));
						// ischeck[nextx][nexty] = false; //방문 처리 해제
						// isStop ++;
					} else if (iscut == 0) {// 현재 보다 낮지 않고 깎은적 없으면
						if (nowheight <= mt[nextx][nexty] - k) { // k만큼 깎은것보다도 작으면
							// newvisit[nextx][nexty] = true; //방문 처리
							continue;
						}
						queue.add(new inputQ(nextx, nexty, nowheight-1, 1, count + 1, newvisit)); // 최대가 k 니까
																											// 1~k 까지
																											// 줌!!!
						// ischeck[nextx][nexty] = true;
						// queue.add(new inputQ(nextx,nexty,mt[nextx][nexty]-k,1,count+1,ischeck));
						// //iscut 1로 바꿔줘야함
						// ischeck[nextx][nexty] = false; //방문 처리 해제
						// isStop ++;
					}

				}
			}

//			if(isStop == 0) {//더이상 이동할 곳이 없다면
//				if(count>max) max = count;
//			}

		}
	}
}