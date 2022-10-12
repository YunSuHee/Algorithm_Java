package 수업_0928;

//빌리지 손가락
public class 그래프_02_DFS {
	// 인접행렬
	static int N = 7;
	static int[][] adj = { { 0, 1, 1, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 1, 0, 0 } };
	static boolean[] visited = new boolean[N];

	public static void main(String[] args) {
		dfs(0);
	}
	// 스택 직접 이용할 수 도 있었꼬.
	// 재귀를 이용하면 알아서 시스템 스택을 이용하니 딱히 생각할 필요는 없더라
	
	static void dfs(int V) {
		//박문철2
		visited[V] = true;
		//나님 등장 나는 사실 알파벳
		//대전4반 장유범(이것이정답)
//		System.out.println((char)(V+65));
		//서울8반 이신광
//		System.out.println((char)V+'A');
		//서울7반 이상현
//		System.out.println((char)V-'0'+'A');
		
		
		//인접행렬을 순회하면서
		for(int i = 0 ; i<N ;i++) {
			//방문하지 않았고, 그래프가 연결되어 있다면 
			if(!visited[i] && adj[V][i] == 1)
				dfs(i);
		}
	}
}
