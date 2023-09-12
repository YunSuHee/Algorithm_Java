import java.util.*;
class Solution {
    static boolean[][] visit;
    public int solution(int n, int[][] computers) {
        visit = new boolean[n][n];
        int answer = 0;
        for(int i=0; i<n; i++){    
            Queue<int[]> queue = new LinkedList<>();
            for(int j=0; j<n; j++){
                if(!visit[i][j] && computers[i][j]==1){
                    visit[i][j] = true;
                    visit[j][i] = true;
                    queue.add(new int[]{i,j});
                }
            }
            if(!queue.isEmpty()){
              answer++;
              bfs(n,computers,queue);  
            }          

        }
        return answer;
    }
    static void bfs(int n,int[][] computers,Queue<int[]> queue){      
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int row = now[1];
            for(int j=0; j<n; j++){
                if(!visit[row][j]&&computers[row][j]==1){
                    visit[row][j] = true;
                    visit[j][row] = true;
                    queue.add(new int[]{row,j});
                }
            }
        }
            
   }

}