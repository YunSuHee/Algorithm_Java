import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] visit;

    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }
        visit = new boolean[n+1];
        dfs(start);
        System.out.println();
        visit = new boolean[n+1];
        bfs(start);
    }
    static void dfs(int start){
        visit[start] = true;
        System.out.print(start+" ");

        for(int i=0; i<=n; i++){
            if(!visit[i] && map[start][i] ==1){
                dfs(i);
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while(!queue.isEmpty()){
            int a = queue.poll();
            System.out.print(a+" ");
            for(int i=0; i<=n; i++){
                if(!visit[i]&& map[a][i]==1){
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}