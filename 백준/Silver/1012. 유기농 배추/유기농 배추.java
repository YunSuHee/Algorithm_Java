import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] field, check;
	static int m,n,count;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 0; t < tc; t++) {
			
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();
			count = 0;
			field = new boolean[m][n];
			check = new boolean[m][n];
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x][y] = true;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (!check[i][j] && field[i][j]) {
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nx = temp[0];
			int ny = temp[1];
			
			for(int i=0; i<4;i++) {
			int nextx = nx+dx[i];
			int nexty = ny+dy[i];
			if(nextx>=0 && nextx<m && nexty>=0 && nexty<n && field[nextx][nexty]) {
				if(check[nextx][nexty]) continue;
				check[nextx][nexty] = true;
				queue.add(new int[] {nextx, nexty});
			}
			}
		}
		count++;
	}
}
