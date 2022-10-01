package temp;
import java.util.*;

public class 섬의개수_4963 {
	static int w, h, result;
	static int[][] map;
	static boolean[][] check;
	static int[] dx = {1,-1,0,0,1,-1,1,-1}; //8방 탐색
	static int[] dy = {0,0,1,-1,1,1,-1,-1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			w = sc.nextInt();
			h= sc.nextInt();
			if(w+h == 0) break;
			result = 0;
			
			map = new int[h][w];
			check = new boolean[h][w];
			
			for (int i=0; i<h;i++) {
				for(int j=0;j<w;j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<h;i++) {
				for(int j=0; j<w;j++) {
					if(!check[i][j] && map[i][j] ==1) {
						bfs(i,j);
					}
				}
			}

			System.out.println(result);
		}

	}
	
	static void bfs(int x,int y) {
		Queue<int[]> queue = new LinkedList<>();
		int[] n = {x,y};
		queue.add(n);
		
		check[x][y] = true;
		while(!queue.isEmpty()) {
			int[] data = queue.poll();
			int a = data[0];
			int b = data[1];
			
			for(int i=0; i<8;i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx>=0 && nx<h && ny>=0 && ny<w && map[nx][ny] == 1) {
					if(check[nx][ny]) continue;
					check[nx][ny] = true;
					queue.add(new int[] {nx,ny});
				}
			}
			
			
		}
		result++;
		
	}

}
