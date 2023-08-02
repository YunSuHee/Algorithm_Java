import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            double restDay = (double)(100-progresses[i])/speeds[i];
            days[i] = (int)Math.ceil(restDay);
            
        }
        //하루에 몇개가 배포가 되는지
        int num = 1;
        //배포 날짜
        int day = days[0];
        for(int i=1; i<progresses.length; i++){
            if(days[i] <= day){//배포해야하는 날짜가 현재 날짜보다 같거나 작으면 배포가능한 기능
                num ++;
            }else{
                list.add(num);
                num = 1;
                day = days[i];                
            }
            
        }
        list.add(num); //마지막 남아있던거
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}