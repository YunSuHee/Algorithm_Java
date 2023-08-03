import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //1. 큐가 비어있을 경우
        //2. 큐가 꽉차있을 경우
        //3. 큐가 가득차지 않은 경우
        //3-1. 새로운 트럭이 들어왔을때 무게가 초과 되는 경우
        //3-2. 새로운 트럭이 들어왔을때 무게가 초과 되지 않는 경우
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int sum = 0;
        for(int i=0; i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
                //queue가 비어있는 경우
                if(q.isEmpty()){
                    q.add(truck);
                    sum = truck;
                    time ++;
                    break;
                }//queue가 꽉 찬 경우
                else if(q.size()==bridge_length){
                    sum -= q.poll();
                }//queue가 꽉 차지 않은 경우
                else{
                    if(sum + truck > weight){ //무게가 초과 했을때
                        q.add(0);
                        time ++;
                    }else{
                        q.add(truck);
                        time ++;
                        sum += truck;
                        break;
                    }
                }
            }
        }
        //다리길이만큼 지나가야하니까
        return time+bridge_length;
    }
}