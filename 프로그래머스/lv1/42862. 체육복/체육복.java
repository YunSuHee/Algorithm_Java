import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        //도난 당한 학생
        for(int i=0; i<lost.length;i++){
            int idx = lost[i]-1;
            arr[idx] = 0;
        }
        //여유분 가져온 학생
        for(int i=0; i<reserve.length; i++){
            int idx = reserve[i]-1;
            arr[idx] += 1;
        }
        
        //체육복 빌려주기
        for(int i=0; i<n;i++){
            //체육복 없는 학생만 체크
            if(arr[i] != 0) continue;
            int front = i-1;
            int back = i+1;
            if(front>=0 && arr[front]==2){
                arr[front] =1;
                arr[i] = 1;
            }else if(back <n && arr[back] == 2){
                arr[back] = 1;
                arr[i] = 1;
            }
            
        }
        for(int i=0; i<n; i++){
            if(arr[i] >= 1) answer++;
            
        }
        return answer;
    }
}