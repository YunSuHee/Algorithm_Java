class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        int[][] sum = new int[n+1][m+1];


        for(int i=0; i<skill.length; i++){
            int type = skill[i][0] == 1 ? -1 :1; //1(공격)이면 -1 2(회복)이면 +1
            int xStart = skill[i][1];
            int xEnd = skill[i][3] + 1;
            int yStart = skill[i][2];
            int yEnd = skill[i][4] +1;
            int degree = skill[i][5];

            sum[xStart][yStart] += degree*type;
            sum[xStart][yEnd] -= degree*type;
            sum[xEnd][yStart] -= degree*type;
            sum[xEnd][yEnd] += degree*type;
        }

        //누적합
        //좌우
        for(int i=0; i<n ; i++){
            for(int j=1; j<m;j++){
                sum[i][j] += sum[i][j-1];
            }
        }

        //상하
        for(int i=0; i<m; i++){
            for(int j=1; j<n; j++){
                sum[j][i] += sum[j-1][i];
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += sum[i][j];
                if(board[i][j] > 0){
                    answer+=1;
                }
            }
        }
        
        return answer;
    }
}