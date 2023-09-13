import java.util.*;
class Solution {
    static int answer = 0;
    static boolean[] visit;
    public int solution(String begin, String target, String[] words) {
        //1. 한글자 뺴고 나머지가 같은 단어를 찾는다.
        //2. 그 단어가 있으면 방문처리해준다.
        //3. 그리고 그 단어와 cnt를 1증가해 dfs 재귀를 호출한다.
        //4. 모든 경우의 수를 보기위해 방문처리를 false로 한다.
        //5. begin과 target이 같으면 종료한다.
        visit = new boolean[words.length];
        dfs(begin,target,0,words);
        return answer;
    }
    static void dfs(String begin, String target, int cnt, String[] words){
        if(begin.equals(target)){
          answer = cnt;
          return;
        } 
        for(int i=0; i<words.length;i++){
            if(visit[i]) continue;
            String word = words[i];
            int diff = 0;
            for(int j=0; j<word.length();j++){
                if(begin.charAt(j) != word.charAt(j)) diff++;
            }
            if(diff == 1){
                visit[i] = true;
                dfs(word,target,cnt+1,words);
                visit[i] = false;
            }
            
        }
    }
}