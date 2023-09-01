import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        System.out.println(Arrays.deepToString(costs));
        Arrays.sort(costs,new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });
        System.out.println(Arrays.deepToString(costs));
        return answer;
    }
}
