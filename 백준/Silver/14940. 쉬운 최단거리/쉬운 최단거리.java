import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        int x = 0;
        int y = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==2){
                    x = i;
                    y = j;
                }
            }
        }
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        map[x][y] = 0;
        visit[x][y] = true;
        queue.add(new int[]{x,y,0});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int nowX = info[0];
            int nowY = info[1];
            int d = info[2];
            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && map[nx][ny]!=0 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    map[nx][ny] = d+1;
                    queue.add(new int[]{nx,ny,d+1});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visit[i][j] == false&& map[i][j]!=0){
                    sb.append(-1);
                    sb.append(" ");
                    continue;
                }
                sb.append(map[i][j]+" ");
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }
}