import java.util.Scanner;

public class Main {
    static int n;
    static int result = 0;
    static int[][] map;
    //모래가 이동하는 비율과 a 좌하우상
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    //비율 작은것부터 순서대로 배열에 넣음 1,1,2,2,5,7,7,10,10
    static int[][] dsx = {{-1,1,-2,2,0,-1,1,-1,1},{-1,-1,0,0,2,0,0,1,1},{1,-1,2,-2,0,1,-1,1,-1},{1,1,0,0,-2,0,0,-1,-1}};
    static int[][] dsy = {{1,1,0,0,-2,0,0,-1,-1},{-1,1,-2,2,0,-1,1,-1,1},{-1,-1,0,0,2,0,0,1,1},{1,-1,2,-2,0,1,-1,1,-1}};
    static int[] ratio = {1,1,2,2,5,7,7,10,10};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                map[i][j] = sc.nextInt();
            }
        }

        int x = n/2;
        int y = n/2;
        boolean[][] visit = new boolean[n][n];
        visit[x][y] = true;
        int dir = 0;

        //이동
        while(!(x ==0 && y ==0)){
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(visit[nx][ny]){
                dir = (dir-1+4)%4;//전 방향 한번더
                nx = x+dx[dir];
                ny = y+dy[dir];
            }
            if(map[nx][ny] != 0)  spread(dir,nx,ny, map[nx][ny]);
            visit[nx][ny] = true;
            dir = (dir+1)%4;
            x = nx;
            y = ny;
            //현재 위치 모래는 사라진다
            map[x][y] = 0;
        }

        System.out.println(result);

    }
    static void spread(int dir, int x, int y, int sand){
        int alpha = sand;
        for(int i=0; i<9; i++){
            int nx = x+dsx[dir][i];
            int ny = y+dsy[dir][i];
            int spreadSand = (sand * ratio[i])/100;
            alpha -= spreadSand;
            //map 안이면
            if(nx >=0 && nx<n && ny>=0 && ny<n){
                map[nx][ny]+= spreadSand;
            }else{ //맵 밖이면
                result += spreadSand;
            }
        }
        //alpha 계산
        int nx = x+dx[dir];
        int ny = y+dy[dir];
        //map 안이면
        if(nx >=0 && nx<n && ny>=0 && ny<n){
            map[nx][ny]+= alpha;
        }else{ //맵 밖이면
            result += alpha;
        }

    }
}