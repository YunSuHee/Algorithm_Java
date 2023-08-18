class Solution {
    static boolean[] visit;
    static int max = 0;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return max;
    }
    void dfs(int k, int[][] dungenons, int cnt){

        if(k<0) return;
        max = Math.max(max,cnt);
        for(int i=0; i<dungenons.length; i++){
            if(!visit[i]&&k>=dungenons[i][0]){            
                visit[i] = true;
                dfs(k-dungenons[i][1],dungenons,cnt+1);
                visit[i] = false;
            }
        }
    }
}