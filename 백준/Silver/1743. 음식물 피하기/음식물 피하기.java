import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] prog;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		prog = new int[n][m];
		check = new boolean[n][m];

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			prog[x - 1][y - 1] = 1;
		}
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!check[i][j] && prog[i][j] == 1) {
					int temp = bfs(i,j);
					if(temp>max) {
						max = temp;
					}
				}
			}
		}
		
		System.out.println(max);

	}

	static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		check[x][y] = true;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		int result = 1;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i=0;i<4;i++) {
				int nx = nowx + dx[i];
				int ny = nowy + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<m && prog[nx][ny] ==1) {
					if(check[nx][ny]) continue;
					check[nx][ny] = true;
					queue.add(new int[] {nx,ny});
					result++;
				}
			}
		}
		return result;
	}

}
