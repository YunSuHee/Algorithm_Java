import java.util.*;
class Solution {
    public int[] solution(long n) {
        String N = n+"";
        String[] temp = N.split("");
        int[] answer = new int[temp.length];
        for(int i=temp.length-1; i>=0; i--) {
        	answer[temp.length-1-i]=Integer.parseInt(temp[i]);
        }

        return answer;
    }
}