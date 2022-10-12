import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 그래프_05_다잌스트라_반복문 {
	static class Node {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int V, E; //V : 정점 , E : 간선
	static List<Node>[] adjList; //인접리스트
	static int[] dist; // 최단 길이를 저장할 값들.
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); //0번부터 시작
		E = sc.nextInt();
		
		adjList = new ArrayList[V];
		for(int i = 0 ; i<V; i++)
			adjList[i] = new ArrayList<>();
		
		dist = new int[V];
		Arrays.fill(dist, INF);
		
		///////////////////////////////초기화 완료
		for(int i = 0 ; i<E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			
			//유향 그래프 였어요.
			adjList[st].add(new Node(ed, w)); //인접 리스트에 넣기
			//위의 4줄을 요렇게 작성할 수 있으나 추천하지는 않음. 
//			adjList[sc.nextInt()].add(new Node(sc.nextInt(), sc.nextInt())); 
		}//입력끝
		
		dijkstra(5);
		
		
		System.out.println(Arrays.toString(dist));
		
		
	}
	
	private static void dijkstra(int st) {
		
		boolean[] visited = new boolean[V]; //박문철2 용도
		
		dist[st] = 0; //시작 노드까지의 거리는 0
		
		for(int i = 0 ; i<V-1; i++) {
			int min = INF;
			int idx = -1;
			
			//선택하지 않은 정점 중 dist가 가장 짧은 것을 골라.
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			if(idx == -1) break; //idx -1이라는 뜻은 더이상 연결된게 없어서 할게 없어요 ㅠ
			
			
			visited[idx] = true; //이거 뽑았어요!!!!!!!
			//이제 갱신을 한다.
			for(int j = 0 ; j < adjList[idx].size(); j++	) {
				Node curr = adjList[idx].get(j);
				
				//방문하지 않았고, 연결도 되었고 , 이미가지고 있는 값과 idx까지 온값 + 앞으로 갈값이 더 작으면 갱신
				if(!visited[curr.v] && dist[curr.v] > dist[idx] + curr.weight )
					dist[curr.v]= dist[idx] + curr.weight; 
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
