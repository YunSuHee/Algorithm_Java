package temp;

import java.util.Scanner;
import java.util.*;

public class 미로탐색_2178 {
//dfs  가능한 모든 경우를 찾아야 할 떄
//bfs 최단 거리 , 최단 경로 찾을 떄 
// 이문제는 bfs로 풀어야 함
	static int n,m;
	static int[][] miro;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		
		miro = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String line = sc.nextLine();
			for(int j=0;j<m;j++) {
				miro[i][j] = line.charAt(j)-'0';
			}
		}
		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(miro[n-1][m-1]);

	}
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i=0; i<4;i++) {
				int nx = nowx+ dx[i];
				int ny = nowy+ dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m && miro[nx][ny] == 1) {
					if(visited[nx][ny]) continue;
					
					queue.add(new int[] {nx,ny});
					miro[nx][ny] = miro[nowx][nowy]+1;
					visited[nx][ny] = true;
				}
			}
			
		}
		
	}

}
