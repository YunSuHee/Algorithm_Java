package 수업_0928;

import java.util.LinkedList;
import java.util.Queue;
//와이파이야
public class 그래프_01_BFS {
	public static void main(String[] args) {
		// 인접행렬
		int N = 7;
		int[][] adj = { 
				{ 0, 1, 1, 0, 0, 1, 0 }, 
				{ 1, 0, 0, 1, 0, 0, 1 }, 
				{ 1, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0, 0, 1 }, 
				{ 0, 0, 0, 0, 0, 1, 1 }, 
				{ 1, 0, 0, 0, 1, 0, 0 }, 
				{ 0, 1, 0, 1, 1, 0, 0 } 
			};
		
		//BFS 탐색을 하겠다. 
		Queue<Integer> queue = new LinkedList<>();
		//박문철2
		boolean[] visited = new boolean[N];
		
		//시작정점을 넣고 시작하겠다.
		queue.add(0);
		visited[0] = true;
		
		//큐가 공백상태가 될때까지~~~
		while(!queue.isEmpty()) {
			//정점을 하나 꺼내요.
			int V = queue.poll();
			System.out.println(V+" -> ");
			
			//나와 연결되어 있는 자식노드들을 Q에 추가한다.
			for(int i = 0 ; i <adj.length; i++) {
				//방문하지 않았고 && 너와 내가 연결되어 있으면...
				if(!visited[i] && adj[V][i] == 1) {
					queue.add(i);
					visited[i] = true;//박문철2
				}
			}
			
		}
		
		
		
		
		
		
		
		
		
	}
}
