import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        //진입시점 기준으로 내림차순
        Arrays.sort(routes,(o1,o2)->o2[0]-o1[0]);

        for(int i=0; i<routes.length; i++){
            for(int j=i; j<routes.length;j++){
                if(routes[i][0]<routes[j][0] || routes[i][0]>routes[j][1]){
                    answer++;
                    i=j;
                    continue;
                }
            }
        }
        return answer;
    }
}