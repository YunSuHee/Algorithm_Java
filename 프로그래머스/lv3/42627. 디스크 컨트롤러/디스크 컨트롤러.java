import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; //수행된 요청 개수
        int end = 0; //작업이 완료된 시점
        int idx = 0; //jobs 배열의 인덱스
        
        //원본 배열 오름차순 정렬(요청시점 오름차순)
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        //수행이 끝나고 난 시점보다 요청시점이 앞에 있는 애들중에 작업소요시간이 짧은 순서대로 pq에 넣어야함
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        //요청이 모두 수행될떄까지
        while(count < jobs.length){

            //하나의 작업이 완료되는 시점(end)까지 들어온 모든 요청은 큐에 넣음
            while(idx <jobs.length && jobs[idx][0]<=end){
                pq.add(jobs[idx]);
                idx++;
            }
            //큐가 비어있다면 작업이 완료되고 그 시간 이후에 다시 요청이 들어온다는 의미
            //end를 다시 요청의 가장 처음으로 맞춰줌
            if(pq.isEmpty()){
                end = jobs[idx][0];
            }else{
                int[] temp = pq.poll();
                answer += end- temp[0] + temp[1];
                end += temp[1];
                //하나의 작업이 끝났으니 count는 ++ 해준다.
                count++;
            }
        }
        return (int)Math.floor(answer/jobs.length);
    }
}