import java.util.*;
class Solution {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        //인접행렬에 간선 추가한다.
        //wires 배열을 돌며 선을 하나씩 끊고
        //bfs로 전력망 한개에 연결되어 있는 송전탑 개수를 구한다.
        //두 전력망 차를 구한다.
        //끊은 선 다시 연결한다.
        //선 끊고 연결하는 과정을 반복한다.
        int min = Integer.MAX_VALUE;
        //인접행렬에 추가
        graph = new int[n+1][n+1];
        for(int i=0; i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        //선을 하나씩 끊으며 완전 탐색한다.
        for(int i=0; i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            //간선 끊기
            graph[a][b] = 0;
            graph[b][a] = 0;
            int cnt = bfs(n);
            min = Math.min(min,Math.abs((n-cnt)-cnt));
            //간선 연결
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        
        return min;
    }
    public int bfs(int n){
        int cnt = 1;
        boolean[] visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); //1로시작
        visit[1] = true;
        while(!queue.isEmpty()){
            int start = queue.poll();
            for(int i=1; i<n+1; i++){
                //연결이 되어있고 방문한적 없는 노드
                if(graph[start][i] == 1 && !visit[i]){
                    cnt++;
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
        return cnt;
    }
}