import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        //우선순위큐는 내림차순으로 되어있기때문에 순서대로 queue에서 나간다. 일반적인 큐는 peek 값보다 뒤에 있는 값에
        //우선순위가 더 높은 값이 잇을수 있어 다시 queue에 넣는 행위를 해야하지만 우선순위큐 같은경우는 그럴 필요가 없다.
        //그리고 for문은 게속 순서대로 배열을 돌아 queue가 빌때까지 돌면서 중간에 queue peek 값과 일치하면 queue에서 빼고
        //location까지 일치하면 정답이다.
        while(!pq.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(pq.peek()==priorities[i]){
                    if(i == location){
                        return answer+1;
                    }
                    pq.poll();
                    answer++;
                }
            }
        }
        return answer;
    }
}