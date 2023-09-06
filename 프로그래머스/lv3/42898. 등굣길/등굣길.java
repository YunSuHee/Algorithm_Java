import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        //반례
        //	4, 3, [[1, 2], [2, 1]] -> 0
        //첫째 행과 열에 1로 다 채우고 했더니 위의 경우 0이 안나오고 4가 나옴
        int[][] road = new int[n][m];
        road[0][0] = 1;

        //갈수 없는 곳은 -1
        for(int i=0; i< puddles.length; i++){
            int y = puddles[i][0] -1;
            int x = puddles[i][1] -1;
            road[x][y] = -1;
        }
        //1,1부터 시작해서 왼쪽과 위까지 올 수 있는 경우의 수 더하기 
        for(int i= 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(road[i][j] == -1 ) continue;
                if(i-1 >= 0 && road[i-1][j] != -1) 
                    road[i][j] += road[i-1][j];
                if(j-1 >= 0 && road[i][j-1] != -1) 
                    road[i][j] += road[i][j-1];
                road[i][j] %= 1000000007;
            }
        }
        return road[n-1][m-1];
    }
}