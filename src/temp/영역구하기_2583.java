package temp;

import java.util.*;

public class 영역구하기_2583 {

	static int m, n, k;
	static int[][] area;
	static boolean[][] check;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();
		area = new int[m][n];
		check = new boolean[m][n];
		
		for (int i = 0; i < k; i++) {
			int leftx = sc.nextInt();
			int lefty = sc.nextInt();
			int rightx = sc.nextInt();
			int righty = sc.nextInt();

			for (int j = lefty; j < righty; j++) {
				for (int l = leftx; l < rightx; l++) {
					area[j][l] = 1;
				}
			}
			
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(area[i][j] == 0 && check[i][j] == false) bfs(i,j);
			}

		}
		
		System.out.println(answer.size());
		Collections.sort(answer);
		for(int i : answer) {
			System.out.print(i+" ");
		}
		
	}
	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		check[x][y] = true;
		int result = 1;
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int nowx = temp[0];
			int nowy = temp[1];
			
			for(int i=0;i<4;i++) {
				int nextx = nowx + dx[i];
				int nexty = nowy + dy[i];
				
				if(nextx>=0 && nextx<m && nexty>=0 && nexty<n && area[nextx][nexty] == 0) {
					if(check[nextx][nexty]) continue;
					check[nextx][nexty] = true;
					area[nextx][nexty] = 4;
					result++;
					queue.add(new int[] {nextx, nexty});
					
				}
			}
		} answer.add(result);
	
		
		
	}

}














