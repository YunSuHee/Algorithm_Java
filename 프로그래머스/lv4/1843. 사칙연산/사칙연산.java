import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int[] num = new int[arr.length/2+1];
        String[] oper = new String[arr.length/2];
        for(int i=0; i<arr.length; i++){
            if(i%2 == 0) num[i/2] = Integer.parseInt(arr[i]);
            else oper[i/2] = arr[i];
        }
        int[][] maxDp = new int[num.length][num.length];
        int[][] minDp = new int[num.length][num.length];
        
        //i~i번쨰 까지는 자기 숫자 넣기
        for(int i=0; i<num.length; i++){
            Arrays.fill(maxDp[i],Integer.MIN_VALUE);
            Arrays.fill(minDp[i],Integer.MAX_VALUE);
            maxDp[i][i] = num[i];
            minDp[i][i] = num[i];
        }

        for(int step=1; step<num.length; step++){ //괄호안에 들어갈 숫자 (간격) -> 간격이 0이면 자기만 해당되니까 의미 x
            for(int i=0; i<num.length-step; i++){ //괄호 시작점
                int j = i+ step; //괄호 끝점
                for(int k = i; k < j ; k++){ //숫자 사이에 들어갈 부호확인
                    if(oper[k].equals("+")){

                        //+일 경우 최대값은 최대값+ 최대값
                        maxDp[i][j] = Math.max(maxDp[i][j],maxDp[i][k]+maxDp[k+1][j]);
                        //+ 경우 최소값은 최소값+최소값
                        minDp[i][j] = Math.min(minDp[i][j],minDp[i][k]+minDp[k+1][j]);
                    }else{
                        //-일 경우 최대값은 최대값-최소값
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k]-minDp[k+1][j]);
                        //-일 경우 최소값은 최소값-최대값
                        minDp[i][j] = Math.min(minDp[i][j],minDp[i][k]-maxDp[k+1][j]);
                    }

                }
            }
        }
               

        return maxDp[0][num.length-1];
    }
}