import java.util.*;
class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length();i++){
            char c =s.charAt(i);
            if(c==' '){
                answer.append(" ");
            }else  if(c>='a'&& c<='z'){
                if(c+n>'z'){
                    answer.append((char)(c-26+n));
                }else{
                    answer.append((char)(c+n));
                }
            }else{
                if(c+n>'Z'){
                    answer.append((char)(c-26+n));
                }else{
                    answer.append((char)(c+n));
                }
            }
        }
        return answer.toString();
    }
}