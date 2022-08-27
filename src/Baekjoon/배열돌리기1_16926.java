package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 배열돌리기1_16926 {
	
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> rotate = new ArrayList<>();

	public static void main(String[] args) {
		
		//요약
		// 1. 최종 달팽이 모양으로 출력 될 값 순서를 queue에 넣는 작업
		// 2. queue 값을 출력해서 달팽이 모양 순서대로  result 2차원 배열에 넣기
		// 3. result 배열 출력하기
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt();

		int[][] arr = new int[n][m];

		// 값 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 도는 모양
		// 우, 하, 좌, 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		// 방향
		int dir = 0;

		int x = 0;
		int y = 0;

		int[][] temp = new int[n][m];
		
		
		// 1. 최종 달팽이 모양으로 출력 될 값 순서를 queue에 넣는 작업
		for (int j = 0; j < n * m; j++) {

			// temp 의 역할은 회전 시킬 값을 찾는 용  rotate는 실질적으로 회전할 배열
			temp[x][y] = arr[x][y]; // 현재 값 넣기 //
			rotate.add(arr[x][y]); // 회전 할 값 배열에 저장
			
			// 다음 값 넣기
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 다음꺼가 방향 벗어나면
				dir = (dir + 1) % 4;// 방향 바꾸기
				nx = x + dx[dir]; // 방향 바꿔서 nx ny 재할당
				ny = y + dy[dir];

			}

			if (temp[nx][ny] == 0) { // 다음 값에 들어 갈 수 있으면 
				// x,y 값 바꿔줘
				x += dx[dir];
				y += dy[dir];
			} else if (dir != 3) {// 다음 값에 들어갈수는 없는데 회전을 하지 않아서 방향 바꿔줘야 할때 // 안에 네모

				dir = (dir + 1) % 4;// 방향 바꾸기
				x += dx[dir];
				y += dy[dir];

			} else {// 들어갈 수 없으면 r 만큼 배열 돌려야대 그리고 x,y 위치를 바꿔줘 ! // 밖 네모

				rotateArr(r);

				dir = (dir + 1) % 4;// 방향 바꾸기
				x += dx[dir];
				y += dy[dir];

			}

		}
		if (rotate.size() != 0) {// rotate할게 남아있다는 뜻
			rotateArr(r);
		}

		// 2. queue 값을 출력해서 달팽이 모양 순서대로  result 2차원 배열에 넣기
		int[][] result = new int[n][m];
		x = 0;
		y = 0;
		dir = 0;
		for (int i = 0; i < n * m; i++) {
			result[x][y] = queue.poll();

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m || result[nx][ny] != 0) {// 범위에 벗어나면
				dir = (dir + 1) % 4;

			}
			x += dx[dir];
			y += dy[dir];

		}

		// 3.  result 배열 출력하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void rotateArr(int r) {

		for (int k = 0; k < r; k++) {
			int first = rotate.remove(0); // 처음값 제거
			rotate.add(rotate.size(), first); // 마지막에 추가

		}
		for (int i = 0; i < rotate.size(); i++) {
			queue.add(rotate.get(i));
		}

		rotate.clear(); // arraylist 초기화 해주기
	}
}