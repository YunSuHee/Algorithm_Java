import java.util.*;

public class Main {

    //방문한 국가인지 확인
    static boolean[][] visit;
    //땅 크기, 인구 제한 사항
    static int n,l,r;
    //인구이동하는 국가 정보
    static ArrayList<Pos> list;
    //인구수
    static int[][] population;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();
        //인구 수
        population = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                population[i][j] = sc.nextInt();
            }
        }
        int result = 0;
        //인구 이동이 없을 때까지 반복
        while(true){
            visit = new boolean[n][n];
            boolean move = false;
            for(int i=0; i<n ; i++){
                for( int j=0; j<n; j++){
                    if(!visit[i][j]) {

                        if(bfs(i,j)) move = true; //이동가능한 국경이 있는지 확인
                    }
                }
            }
           if(!move) break;
           result ++;
        }
        System.out.println(result);
    }

    static boolean bfs(int x, int y){
        //이동가능한 나라 리스트
        list = new ArrayList<Pos>();
        Queue<Pos> queue = new LinkedList<>();

        list.add(new Pos(x,y));
        queue.add(new Pos(x,y));
        visit[x][y] = true;

        int total = population[x][y];
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        while(!queue.isEmpty()){
            Pos pos = queue.poll();
            x = pos.x;
            y = pos.y;

            for(int i=0; i<4;i++){
                int nx = x +dx[i];
                int ny = y+ dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n && !visit[nx][ny]){

                    int populationDifference = Math.abs(population[nx][ny]- population[x][y]);
                    //이동할 국가의 인구 수 차이가 l보다 크고 r보다 작은지 확인
                    if(populationDifference >= l && populationDifference<=r){
                        total += population[nx][ny];
                        queue.add(new Pos(nx,ny));
                        list.add(new Pos(nx,ny));
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        if(list.size() > 1) {
            int movingNum = total/list.size();
            //인구 수 변경
            for(Pos pos : list){
                int changeX = pos.x;
                int changeY = pos.y;
                population[changeX][changeY] = movingNum;
            }
            //인구이동이 가능
            return true;
        }
        //인구 인동 불가능
        return false;
    }
    static class Pos{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}