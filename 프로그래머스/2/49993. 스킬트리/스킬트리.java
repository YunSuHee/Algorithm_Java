import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String[] skillArr = skill.split("");
        int[] check;
        for(String sk : skill_trees){
            check = new int[skill.length()];
            String[] temp = sk.split("");
            for(int i=0; i<temp.length; i++){
                for(int j=0; j<skillArr.length;j++){
                    if(temp[i].equals(skillArr[j])){
                        check[j] = i+1;
                        break;
                    }
                }
            }
            
            int min = 0;
            boolean isPossible  = true;

            for(int c : check){
                if(c==0){
                  min = -1; //해당 값이 없으면 그 뒤에 값 모두 0 이어야 함
                  continue;
                } 

                if(min == -1 && c!=0){
                    isPossible = false;
                    break;
                }
                if(min <c){
                    min = c;
                    continue;
                }
                isPossible = false;
                break;
            }
            
            if(isPossible) answer++;
            
        }
        return answer;
    }
}