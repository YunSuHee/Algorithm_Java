import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dice = new int[7];
    public static void main(String[] args) {
        //주사위 이동할 수 있는지 확인 -> x,y 좌표 update -> dice 이동 -> map[x][y]와 dice[6] 확인해서 값 update
        //주사위 모양
        // 2
        //413
        // 5
        // 6
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int k = sc.nextInt();
        map = new int[n][m];

        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }
        int[] dx = {0,0,0,-1,1};
        int[] dy = {0,1,-1,0,0};
        for(int i=0; i<k ;i++){
            int dir = sc.nextInt();
            // 주사위 이동할 수 있는지 확인
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                x = nx;
                y = ny;
                move(x,y,dir);
            }
        }
    }
    static void move(int x, int y, int dir){
        int temp = 0;
        //dice 이동
        switch(dir){
            case 1: //동
                temp = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = dice[1];
                dice[1] = temp;
                break;
            case 2: //서
                temp = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = temp;
                break;
            case 3: //북
                temp = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
            case 4: //남
                temp = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = temp;
                break;

        }
        //map[x][y]와 dice[6] 확인해서 값 update
        // map[x][y]가 0이면, 주사위의 바닥면 수가 칸에 복사
        // 0이 아닌 경우에는 칸에 쓰여 있는 수가 주사위의 바닥면에 복사 + 칸에 쓰여 있는 수는 0이 된다.
        if(map[x][y] == 0){
            map[x][y] = dice[6];
        }else{
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        System.out.println(dice[1]);
    }
}