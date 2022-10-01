import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n,cnt;
	static int[][] area;
	static boolean[][] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		area = new int[n][n];
		
		int max = 0;  //물 최대 높이 수
		int result = 0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				int temp = sc.nextInt();
				area[i][j] = temp;
				if(temp >max) max = temp;
			}
		}
		
		for(int i = 0; i<max;i++) { // i => 물 높이
			check = new boolean[n][n];
			cnt = 0;
			for(int j=0;j<n;j++) {
				for(int k=0; k<n;k++) {
					if(area[j][k]>i && !check[j][k]) { //물높이가 i 보다 크고 , 방문한적이 없어야 함
						bfs(j,k,i);
					}
				}
			}
			
			if(cnt>result) result = cnt;
		}
		
		System.out.println(result);
	}
	private static void bfs(int x, int y, int water) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		check[x][y] = true;
		
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowx = now[0];
			int nowy = now[1];
			
			for(int i=0; i<4;i++) {
				int nx = nowx+ dx[i];
				int ny = nowy + dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && area[nx][ny]>water) {
					if(check[nx][ny]) continue;
					check[nx][ny] = true;
					queue.add(new int[]{nx,ny});
				}
			}
		}
		
		cnt++;
	}

}
