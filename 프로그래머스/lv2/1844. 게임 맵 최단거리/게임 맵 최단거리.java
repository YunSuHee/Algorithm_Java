import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length; //row
        int m = maps[0].length; //col
        boolean[][] visit = new boolean[n][m];
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(0,0,1));
        int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
        
        while(!queue.isEmpty()){
            Info info = queue.poll();
            int x = info.x;
            int y = info.y;
            int cnt = info.cnt;
            
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && maps[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    if(nx == n-1 && ny == m-1) return cnt+1;
                    queue.add(new Info(nx,ny,cnt+1));
                }
            }
            
        }
        return -1;
    }
}
class Info{
    int x;
    int y;
    int cnt;
    //생성자
    public Info(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}