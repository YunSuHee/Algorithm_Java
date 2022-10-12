import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프_04_프림_반복문 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 개수 0부터 시작을 하더라
		int E = sc.nextInt(); // E : 간선의 수

		// 간선의 정보를 저장해야겠다.
		// 인접 행렬(진행) / 인접 리스트(마숙)

		int[][] adjArr = new int[V][V];

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt(); // 시작정점
			int ed = sc.nextInt(); // 도착정점
			int w = sc.nextInt(); // 가중치

			adjArr[st][ed] = w;
			adjArr[ed][st] = w;
		} // 입력
		
		boolean[] visited = new boolean[V]; //박문철2를 위한 용도
		int[] dist = new int[V]; //key라고 불렸던 값을 저장하기 위한 용도
		int[] p = new int[V]; //내가 어디서 왔는지 (부모정보) 저장하기 위한 용도
		
		//dist를 아주아주 큰 값으로 갱신을 하겠다.
//		for(int i = 0 ; i<V; i++)
//			dist[i] = Integer.MAX_VALUE;		
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//임의의 한점을 선택해서 돌릴건데 대게 0번혹은 1번부터 시작하긴 하더라 
		dist[V-1] = 0;
		p[V-1] = -1;
		
		int  ans = 0; //최소비용의 합
		//프림 만든다. 정점의 개수만큼 돌던 정점의 개수 -1만큼 돌던 크게 차이는 없음.
		for(int i = 0 ; i < V-1 ; i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			//아직 안뽑힌 친구덜 중에서 제일 작은 값을 뽑는다.
			for(int j = 0 ; j<V; j++) {
				if(!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}//이 for문 끝나면 idx 에는 내가 이번에 선택한 정점이 들어있다.
			visited[idx] = true; //요거 선택
			//다음으로 할일은?
			//뽑은 친구와 연결되어 있는 간선들을 갱신할 수 있으면 갱신하자.
			//인접행렬이니까
			for(int j = 0 ; j<V; j++) {
				//갱신 , 방문하지 않았고, 간선이 있고
				if(!visited[j] && adjArr[idx][j] != 0 && dist[j] > adjArr[idx][j] ) {
					dist[j] = adjArr[idx][j];
					p[j] = idx;
				}
			}
		}//프림 만들기
		
		for(int i  = 0 ; i<V; i++)
			ans+=dist[i];
		
		System.out.println(Arrays.toString(dist));
		System.out.println(ans);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}// main

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
