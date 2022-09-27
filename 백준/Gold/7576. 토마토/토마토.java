
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] tomato;
	static Queue<int[]> queue = new LinkedList<>();
	static int result =0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		tomato = new int[m][n];


		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int input = sc.nextInt();
				tomato[i][j] = input;
				if (input == 1)
					queue.add(new int[] { i, j });
			}
		}

		while (!queue.isEmpty()) {
			if(checkZero()) {
				bfs();
			}else break;
		}
		if(checkZero()) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}


	}

	static void bfs() {
		
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		
		int size = queue.size();
		for(int l=0; l<size;l++) {
			int[] temp = queue.poll();
			int x = temp[0];
			int y = temp[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (nx >= 0 && nx < m && ny >= 0 && ny < n && tomato[nx][ny] == 0) {
					tomato[nx][ny] = 1;
					queue.add(new int[] {nx,ny});
					
				}
			}
		}result++;

	}
	
	 private static boolean checkZero() {
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (tomato[i][j] == 0)
	                    return true;
	            }
	        }
	        return false;
	    }

}