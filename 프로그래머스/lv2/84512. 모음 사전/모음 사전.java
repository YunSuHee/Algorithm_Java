import java.util.*;
class Solution {
    //static List<String> list = new ArrayList<>();
    static String[] words = new String[]{"A","E","I","O","U"};
    static int cnt = -1;
    static boolean check = false;
    public int solution(String word) {
        //재귀로 word가 나올때까지 순서대로 나열
        recursion(word,"",0); 
        
        return cnt;
    }
    public void recursion(String word, String str, int depth){
        
        if(check) return; //답이 나왔기 떄문에 return
        cnt++;
        if(word.equals(str)){
            check = true;
            return;
        }
        if(depth == 5) return;
        for(int i=0; i<5;i++){
            recursion(word,str+words[i],depth+1);
            
        }
    }
}