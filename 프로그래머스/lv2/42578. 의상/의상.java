import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1])){
                map.put(cloth[1],map.get(cloth[1])+1);
            }else{
                map.put(cloth[1],1);
            }
        }

        for(String key : map.keySet()){
            answer *= map.get(key)+1;
        }
        //하루에 최소 한개의 이상은 입으니까 아무것도 입지 않은 경우를 뺀다.
        return answer-1;
    }
}