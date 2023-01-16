import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int r, c;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new int[r][c];
	
		
		int cheese = 0; // 치즈 칸 수
		int time = 0;// 시간
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					cheese += 1;
				}
			}
		}
		int answer = 0;
		
		while(cheese != 0) {
			time +=1;
			checkhole(); // 구멍과 공기 분리
			disappearcheese(); //공기와 접촉한 치즈 없애기
			int temp = countcheese();
			if(temp == 0) {
				answer = cheese;
			}
			cheese = temp;
		}
		System.out.println(time);
		System.out.println(answer);

	}

	private static int countcheese() {
		int cnt = 0;
		for(int i=0; i<r; i++) {
			for(int j=0 ; j<c;j++) {
				if(map[i][j] == 1) {
					cnt+=1;
				}
			}
		}
		return cnt;
	}

	private static void disappearcheese() {
		for(int i=0 ; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] == 1) {
					//치즈 주변에 공기와 접촉 부분이 있나 확인
					for(int k = 0; k<4; k++) {
						int nx = i+dx[k];
						int ny = j + dy[k];
						if(nx >=0 && nx<r && ny>=0 && ny<c && check[nx][ny]) {
							map[i][j] = 0; //주변에 공기 있으면 치즈 녹음
							continue;
						}
					}
				}
			}
		}
		
	}

	private static void checkhole() { //check 에 true 인곳만 공기가 접촉 한 곳
		check = new boolean[r][c];
		
		check[0][0] = true;
		 Queue<int[]> queue = new LinkedList<>();
		 queue.add(new int[] {0,0});
		
		
		 while(!queue.isEmpty()) {
			 int[] temp = queue.poll();
			 int x = temp[0];
			 int y = temp[1];
			 
			 for(int i = 0; i<4; i++) {
				 int nx = x+dx[i];
				 int ny = y +dy[i];
				 if(nx >=0 && nx<r && ny>=0 && ny<c && !check[nx][ny]&& map[nx][ny] == 0 ) {
					 check[nx][ny] = true;
					 queue.add(new int[] {nx,ny});
				 }
			 }
		 }
		
	}

}