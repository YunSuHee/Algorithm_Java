import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] letter = s.toCharArray();
        Queue<Character> q = new LinkedList<>();

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        //System.out.println(q);

        for(int i=0; i<letter.length;i++){
            if(q.isEmpty()&&letter[i]==')') return false;
            
            if(q.isEmpty() || q.peek()==letter[i]){
                q.add(letter[i]);
            }else{
                q.poll();
            }
        }
        answer = q.size() > 0 ? false:true;
        return answer;
    }
}