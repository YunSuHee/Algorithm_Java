import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min =Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] sArr = s.split(" ");
        
        for(int i=0; i<sArr.length;i++){
           

            int temp = Integer.parseInt(sArr[i]);
            if(temp>max) max = temp;           
            if(temp<min) min = temp;
            
        }
        
        answer = min+" "+max;
        return answer;
    }
}