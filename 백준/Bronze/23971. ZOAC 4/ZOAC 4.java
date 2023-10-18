import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int height = (h - 1) / (n + 1) + 1;
        int width = (w - 1) / (m + 1) + 1;
        System.out.println(height*width);
//        int[][] room = new int[h][w];
//        int x = 0;
//        int y = 0;
//        room[x][y] =1;
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{x,y});
//        while(!queue.isEmpty()){
//            int[] temp = queue.poll();
//            x = temp[0];
//            y = temp[1];
//            int nx = x+n+1;
//            int ny = y+m+1;
//
//            if(nx<h){
//                room[nx][y] = 1;
//                queue.add(new int[]{nx,y});
//            }
//            if(ny<w){
//                room[x][ny] = 1;
//                queue.add(new int[]{x,ny});
//            }
//
//        }
//        int answer =0;
//        for(int i=0; i<h; i++){
//            for(int j=0; j<w; j++){
//                if(room[i][j]==1)answer++;
//            }
//        }
//        System.out.println(answer);
    }
}