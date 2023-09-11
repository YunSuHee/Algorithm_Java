import java.util.*;
class Solution {
    static int answer = 0;
    static int Target;
    static int N;
    static int[] Numbers;
    static int[] operation = {1,-1};
    public int solution(int[] numbers, int target) {
        //총 경우의 수는 2^20 1억이 안되기 때문에 완탐
        Target = target;
        N = numbers.length;
        Numbers = numbers;
        dfs(0,0);
        
        return answer;
    }
    public void dfs(int total, int depth){
        
        if(depth == N){
            if(total == Target) answer++;
            return;
        }

        for(int i=0; i<2; i++){
            int value = operation[i] * Numbers[depth];
            dfs(total+value,depth+1);
        }
    }
    
}