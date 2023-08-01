import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //참여자 수를 hashmap으로 하고 
        //completion에서 map 제거
        Map<String,Integer> map = new HashMap<>();
        for(String part : participant){
            if(map.containsKey(part)){
                map.put(part,map.get(part)+1);
            }else{
                map.put(part,1);
            }
        }
        for(String comple : completion){
            if(map.get(comple)>1){
                map.put(comple,map.get(comple)-1);
            }else{
                map.remove(comple);
            }
        }
        for(String m:map.keySet()){
            answer = m;
        }
        return answer;
    }
}