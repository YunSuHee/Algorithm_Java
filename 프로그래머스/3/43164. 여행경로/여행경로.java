import java.util.*;
class Solution {
    static List<String> answer = new ArrayList<>();
    static boolean[] visit;
    //static Map<String,List<String>> info = new HashMap<>();
    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        dfs(0,"ICN","ICN",tickets);
        Collections.sort(answer);
        
        
        return answer.get(0).split(" ");
    }
    static void dfs(int depth, String start, String path, String[][] tickets){
        if(depth == tickets.length){
            answer.add(path);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(start)&&!visit[i]){
                visit[i] = true;
                dfs(depth+1, tickets[i][1], path+" "+tickets[i][1],tickets);
                visit[i] = false;
            }
        }
     }
}

