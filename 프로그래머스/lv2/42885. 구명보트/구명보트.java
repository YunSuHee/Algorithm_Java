import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        //1.배열을 정렬한다.
        //2.제일 작은수와 제일 큰 수 합이 limit를 넘지 않으면 구명보트에 태운다.
        //3.만약 limit를 넘으면 제일 큰수만 구명보트에 태운다. 
        //그리고 2와 3을 반복한다.
        //투포인터로 해도 되고 deque로 해도 됨
        int answer = 0;
        Arrays.sort(people);
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<people.length;i++){
            queue.add(people[i]);
        }
        while(!queue.isEmpty()){
            int min = queue.peekFirst();
            int max = queue.peekLast();
            if(min+max<=limit){                
                queue.pollFirst();
                queue.pollLast();
            }else{
                queue.pollLast();
            }
            answer++;
        }

        return answer;
    }
}
