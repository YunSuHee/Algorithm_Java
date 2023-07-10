import java.util.*;


public class Main {

    static boolean map[][] = new boolean[101][101];
    //우상좌하 (방향 0,1,2,3)
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt(); // 시작 방향
            int g = sc.nextInt(); //세대
            //커브 그리기
            drawCurve(x,y,d,g);
        }
        //사각형인지 확인하기
        int answer = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]){
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }

    private static void drawCurve(int x, int y, int d, int g) {
        List<Integer> dir = new ArrayList<>();
        //첫번쨰 방향 추가하기
        dir.add(d);
        //시작점 map에 true로 바꾸기
        map[x][y] = true;
        //이미 0세대는 추가했기 때문에 1세대부터 g 세대 까지
        for(int i=1; i<=g; i++){
            for(int j = dir.size()-1; j>=0; j--){ //현재 세대 = 전세대대의 방향 + 전 세대의 방향을 뒤집은 후에 1을 더한값을 추가
                dir.add((dir.get(j)+1)%4);
            }
        }

        //커브 만들어진 좌표 map에 true로 만들기
        for(int i : dir){
            x+= dx[i];
            y+= dy[i];
            map[x][y] = true;
        }

    }



}