import java.util.*;
class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;
      
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(!visit[i]){
                answer++;
                visit[i] = true;
                queue.add(i);
                while(!queue.isEmpty()){
                    int row = queue.poll();

                    for(int j=0; j<n; j++){
                        if(!visit[j]&&computers[row][j]==1){
                            visit[j] = true;
                            queue.add(j);
                        }
                    }
                }
                
            }
        }

        return answer;
    }


}