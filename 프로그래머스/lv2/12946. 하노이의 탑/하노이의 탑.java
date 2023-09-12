import java.util.*;
class Solution {
    static int[][] result;
    static int idx = 0;
    public int[][] solution(int n) {
        //n은 이동해야할 원판 수
        //n-1까지 2번막대기로 이동 후 n 번이 3번막대기로 이동하면 2번막대기에 있는 n-1이 3번막대기로 이동한다.
        //n이 1이 되면 이동을 하기 떄문에 result 배열에 값 넣어야 한다.

        
        result = new int[(int)Math.pow(2,n)-1][2];
        hanoi(n,1,2,3);
        return result;
    }
    public void hanoi(int n, int start, int mid, int end){
        if(n == 1){
            move(start,end);
            return;
        }else{
            //n-1까지 2번 막대기로 이동
            hanoi(n-1,start,end,mid); //거쳐가는 지점 = 3(end), 목표 지점(sub)
            //n 3번막대기로 이동
            move(start,end);
            //2번 막대기에 있는 n-1까지의 수 3번막대기로 이동
            hanoi(n-1,mid,start,end);//시작 =sub, 거쳐가는 지점 = start, 목표 = end
        }
    }
    public void move(int start,int end){
        result[idx][0] = start;
        result[idx][1] = end;
        idx++;
    }
}