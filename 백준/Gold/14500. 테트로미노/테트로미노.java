import java.util.Scanner;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visit;
    static int answer = 0;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visit[i][j]){
                    visit[i][j] = true;
                    check(i,j,map[i][j],1);
                    visit[i][j] = false;
                }
            }
        }
        System.out.println(answer);

    }
    static void check(int x, int y, int sum, int depth ){
        if(depth == 4){
            answer = Math.max(answer,sum);
            return;
        }
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m && !visit[nx][ny]){
                if(depth == 2){
                    visit[nx][ny] = true;
                    check(x,y,sum+map[nx][ny],depth+1);
                    visit[nx][ny] = false;
                }
                visit[nx][ny] = true;
                check(nx,ny,sum+map[nx][ny],depth+1);
                visit[nx][ny] = false;

            }
        }
    }


}