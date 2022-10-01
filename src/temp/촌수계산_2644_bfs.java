package temp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 촌수계산_2644_bfs {
	static int n,x,y,m;
	static int[][] people;
	static int[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		x=sc.nextInt()-1;
		y=sc.nextInt()-1;
		m=sc.nextInt();
		people = new int[n][n];
		
		for(int i=0; i<m;i++) {
			int X = sc.nextInt()-1;
			int Y = sc.nextInt()-1;
			people[X][Y] = 1;
			people[Y][X] = 1;
			
		}

		
		check = new int[n];
		bfs(x);
		if(check[y] == 0) {
			System.out.println(-1);
		}else {
			System.out.println(check[y]);
		}

	}
	static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);

		while(!queue.isEmpty()) {
			int now = queue.poll();
;
			if(now == y) break;
			for(int i=0; i<n;i++) {

				if(people[now][i] ==1 && check[i]==0 ) {

					queue.add(i);
					check[i] = check[now]+1;

				}
			}
		}
	}

}
