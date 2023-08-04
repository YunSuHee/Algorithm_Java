import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        //오름차순을 한게 기준을 citations[i] 나로 잡자나!! 그럼 내 뒤에 있는 애들은 무조건 나보다 큰거니까 h를 개산할때 citations.length -i를 해도 된다.
        Arrays.sort(citations);
        for(int i=0; i<citations.length;i++){
            int h = citations.length-i;
            if(citations[i]>=h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}