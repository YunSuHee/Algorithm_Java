
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] graph;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int start = sc.nextInt();
		
		graph = new int[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
			graph[b][a] = 1;
			
		}

		dfs(start);
		System.out.println();
		Arrays.fill(check, false);
		bfs(start);

	}
	static void dfs(int start) {
		check[start] = true;
		System.out.print(start+" ");
		
		for(int i=1; i<graph.length;i++) {
			if(graph[start][i]==1 && check[i] == false) {
				dfs(i);
			}
		}
	}
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		check[start] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now+" ");
			for(int i=0; i<graph.length;i++) {
				if(graph[now][i] == 1 && check[i] == false) {
					check[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
