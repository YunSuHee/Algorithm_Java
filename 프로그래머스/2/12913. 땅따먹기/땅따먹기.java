import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<m; i++){
          dp[n-1][i] = land[n-1][i];
        }
        if(n ==1 ){
            for(int i=0; i<4; i++){
                answer = Math.max(answer,dp[0][i]);
            }
            return answer;
        }
        for(int i=n-2; i>=0 ; i--){
            for(int j=0; j<m; j++){
                for(int k=0; k<m; k++){
                    if(j==k) continue;
                    
                    dp[i][j] = Math.max(dp[i][j], dp[i+1][k]+land[i][j]);
                }
            }
        }
       for(int i=0; i<4; i++){
                answer = Math.max(answer,dp[0][i]);
       }
 
        return answer;
    }
}