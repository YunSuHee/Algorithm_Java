import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int n,m;
    static int[] dx = {0,-1,-1,-1,0,1,1,1}; //←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[][] map;
    static boolean[][] visit;
    static Queue<Cloud> clouds = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];
        visit = new boolean[n][n]; //구름이 생겼었는지 확인
        //물양 확인
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        //초기 구름
        clouds.add(new Cloud(n-1,0));
        clouds.add(new Cloud(n-1,1));
        clouds.add(new Cloud(n-2,0));
        clouds.add(new Cloud(n-2,1));


        for(int i=0; i<m; i++){
            int d = sc.nextInt()-1;
            int s = sc.nextInt();
            moveAndIncrease(d,s); //이동 후 구름 물 증가
            disappearAndCheck(); //구름 사라지고 대각선 check
            makeCloud(); //구름 생성

        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

    }
    static void moveAndIncrease(int d, int s){
        //값 이동 후 증가
        for(Cloud cloud : clouds){
            cloud.x = (n+cloud.x+dx[d]*(s%n))%n; //음수일 수도 있으니 앞에 n을 더함(s%n을 해줬기 떄문에 무조건 양수가 나옴)! 양수일 경우 앞에 n을 더해줬으니 %n으로 나눔
            cloud.y = (n+cloud.y+dy[d]*(s%n))%n;
            //구름 물 증가
            map[cloud.x][cloud.y]++;
        }

    }
    static void disappearAndCheck(){
        //구름제거, 대각선 물바구니 있으면 증가
        while(!clouds.isEmpty()){
            //제거
            Cloud cloud = clouds.poll();
            visit[cloud.x][cloud.y] = true;

            //대각선 증가
            int cnt = 0;
            for (int i=1; i<8; i+=2){
                int nx = cloud.x+dx[i];
                int ny = cloud.y+dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny]>0){
                    cnt++;
                }
            }
            map[cloud.x][cloud.y] += cnt;
        }
    }
    static void makeCloud(){
        //물의양이 2이상인 모든칸 구름 생기고 물양 -2 단 구름이 이미 생겼다 사라진 칸은 무시
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                if(map[i][j] >=2 && !visit[i][j]){
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i,j));
                }
            }
        }
        //구름 생겼던 기록 초기화
        visit = new boolean[n][n];
    }
    static class Cloud{
        int x;
        int y;
        public Cloud(int x, int y){
            this.x = x;
            this.y =y;
        }
    }
}