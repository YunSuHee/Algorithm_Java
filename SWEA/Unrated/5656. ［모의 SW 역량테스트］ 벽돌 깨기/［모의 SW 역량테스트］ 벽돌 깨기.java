import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int n,w,h;
    static int[][] map;
    static int[] out;
    static int answer;
    static int[] dx = {0,0,1,-1}; //우,좌,하,상
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            out = new int[n];
            for(int i=0; i<h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //중복순열
            permutation(0);
            System.out.println("#" + tc + " " + answer);
        }

    }
    static void permutation(int depth){
        if(depth == n){
            answer = Math.min(game(out),answer);
            return;
        }
        for(int i=0; i<w;i++){
            out[depth] = i;
            permutation(depth+1);
        }
    }
    static int game(int[] out){
        int[][] newMap = new int[h][w];
        for(int i=0; i<h;i++){
            newMap[i] = map[i].clone();
        }
        for(int i=0; i<out.length; i++){ //떨어 뜨리는 위치
            //어떤 위치에서 구슬 떨어뜨리는지 찾기
            int x = -1;
            int y = out[i];
            for(int k =0; k<h; k++){
                if(newMap[k][y] !=0){
                    x=k;
                    break;
                }
            }
            //벽돌 제거
            if(x != -1) broke(x,y,newMap);
            //빈공간 정렬
            sortBlank(newMap);

        }


        return count(newMap);
    }
    static void broke(int X, int Y, int[][] newMap){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X,Y});
        while(!queue.isEmpty()){
            int[] pos =queue.poll();
            int x = pos[0];
            int y = pos[1];
            int num = newMap[x][y]-1;
            newMap[x][y] = 0;
            for(int i=0; i<4;i++){
                int nx = x; int ny = y;
                for(int j=0; j<num; j++){
                    nx += dx[i];
                    ny += dy[i];
                    if(nx>=0 && ny>=0 && nx<h && ny<w){
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }
    static void sortBlank(int[][] newMap){
        for(int y=0; y<w; y++){
            int index = h-1;
            for(int x=h-1;x>=0; x--){
                if(newMap[x][y] != 0){
                    int temp = newMap[x][y];
                    newMap[x][y] = 0;
                    newMap[index][y] = temp;
                    index--;
                }
            }
        }
    }
    static int count(int[][] newMap){
        int cnt = 0;
        for(int i=0; i<h;i++){
            for(int j=0; j<w; j++){
                if(newMap[i][j] !=0) cnt++;
            }
        }
        return cnt;
    }


}