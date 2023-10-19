import java.util.*;
class Solution {

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        int answer = Integer.MAX_VALUE;
        boolean[][] visit =new boolean[101][101];
        //태두리 채우기
        for(int i=0; i<rectangle.length;i++){
            int startX = rectangle[i][0]*2;
            int startY = rectangle[i][1]*2;
            int endX = rectangle[i][2]*2;
            int endY = rectangle[i][3]*2;
            for(int j=startX; j<=endX; j++){
                for(int k = startY; k<=endY; k++){
                   if(map[j][k]==2) continue;
                    map[j][k] =2;
                    if(j==startX || j==endX || k==startY || k ==endY){
                        map[j][k] =1;
                    }
                }
            }
            
        }
      
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX*2,characterY*2,0});
        visit[characterX*2][characterY*2] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int d = now[2];
            if(x==itemX*2 && y==itemY*2){
                answer = Math.min(d,answer);
            }
            for(int i=0; i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx>=0 && ny>=0 && nx<101 && ny<101 && map[nx][ny] ==1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    queue.add(new int[]{nx,ny,d+1});
                }
                
            }
        }
        return answer/2;
    }
}