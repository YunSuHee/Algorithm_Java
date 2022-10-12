import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 그래프_04_프림_우선순위큐 {
	static class Edge implements Comparable<Edge> {
		int st, ed, cost;

		public Edge(int st, int ed, int cost) {
			this.st = st;
			this.ed = ed;
			this.cost = cost;
		}

		// 우선순위큐를 활용하기 위해서 기준을 정해준다.
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
//			return Integer.compare(this.cost, o.cost);
		}

		@Override
		public String toString() {
			return "Edge [st=" + st + ", ed=" + ed + ", cost=" + cost + "]";
		}
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 개수 0부터 시작을 하더라
		int E = sc.nextInt(); // E : 간선의 수

		// 간선의 정보를 저장해야겠다.
		// 인접 행렬(마숙) / 인접 리스트(진행)

		// 인접리스트 초기화
		List<Edge>[] adjList = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt(); // 시작정점
			int ed = sc.nextInt(); // 도착정점
			int w = sc.nextInt(); // 가중치

			adjList[st].add(new Edge(st, ed, w));
			adjList[ed].add(new Edge(ed, st, w));
		} // 입력

		boolean[] visited = new boolean[V]; // 박문철2 용도

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		// 시작 정점을 하나 뽑아야해.
		visited[0] = true;

//		for(int i = 0 ; i<adjList[0].size(); i++)
//			pq.add(adjList[0].get(i));

		pq.addAll(adjList[0]); // 요렇게 작성도 되더라.

		int pick = 1; // 확보한 정점의 갯수
		int ans = 0;

		// pick < V
		while (pick != V) {
			Edge edge = pq.poll(); // 연결된 간선을 하나 뽑았어.
			if (visited[edge.ed])
				continue; // 이미 뽑은 정점이었다면 넘어가

			ans += edge.cost;
			pq.addAll(adjList[edge.ed]);
			visited[edge.ed] = true;
			pick++;
		}
		System.out.println(pq.size());
		System.out.println(ans);

	}// main

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
