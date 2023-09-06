import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        //삼각형 높이
        int n = triangle.length;
        //삼각형을 board에 직각 삼각형 형태로 담기
        int[][] board = new int[n][n];
        //더해지는 dp값 저장
        int[][] dp = new int[n][n];
        //board에 값 저장
        for(int i=0; i<n;i++){
            int m = triangle[i].length;
            for(int j=0; j<m;j++){
                board[i][j] = triangle[i][j];
            }
        }
        //초기값
        dp[0][0] = board[0][0];
        for(int i=1; i<n; i++){
            for(int j=0; j<i+1; j++){
                //위에 있는 경우, 왼쪽 대각선 있는 경우
                int up = i-1;
                int upleft = j-1;
                if(upleft <0){ //왼쪽 대각선에 값이 없을때엔 위에 있는 값만 더해줌
                    dp[i][j] = dp[up][j] + board[i][j];
                    continue;
                }
                //위에있는 값과 왼쪽 대각선에 있는 값중에 더 큰값과 현재 위치에 있는 값을 더하기
                dp[i][j] = Math.max(dp[up][j],dp[up][upleft])+board[i][j];
                answer = Math.max(answer,dp[i][j]);
                
            }
        }

        return answer;
    }
}