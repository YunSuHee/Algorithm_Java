import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] durability = new int[n*2];
        boolean[] robotCheck = new boolean[n*2];
        for(int i=0; i<2*n;i++){
            durability[i] = sc.nextInt();
        }
        int level = 0;
        int start = 0;
        int end = n-1;
        int zeroCnt = 0;
        Queue<Integer> robotIdx = new LinkedList<>();
        while(true){
            level++;
            // 1. 컨베이어 벨트 이동
            start = start-1<0 ? 2*n-1 : start-1; // 시작점을 뒤로 -1, 시작점이 0일땐 맨 뒤로
            end = end-1<0 ? 2*n-1 : end-1;
            // 2. 로봇이동
            int robotCnt = robotIdx.size();
            for(int i=0; i<robotCnt; i++){
                int idx = robotIdx.poll();
                if(idx == end) {
                    robotCheck[idx] = false;  //마지막 위치니 로봇 내리기
                    continue; //현재 위치가 마지막 위치였으면 바로 내리기
                }
                int nextIdx = (idx+1)%(2*n);
                if(!robotCheck[nextIdx] && durability[nextIdx]>0){ //다음칸에 로봇이 없고 내구도가 0이상이면 내구도 감소
                    robotCheck[idx] = false; //이동하니 로봇 내리기
                    durability[nextIdx] -= 1;
                    if(nextIdx!=end){ //다음으로 이동할 칸이 마지막 칸이 아니면 로봇이동 후 방문 처리하고 queue에 넣어줌
                        robotIdx.add(nextIdx);
                        robotCheck[nextIdx] = true;
                    }
                    if(durability[nextIdx]==0) zeroCnt++;
                }else{ //다음칸으로 로봇 이동할 수 없다면 현재칸에 로봇 다시 넣어
                    robotIdx.add(idx);
                }
            }

            //3. 로봇 올린다.
            if(durability[start]>0){
                robotCheck[start] = true;
                durability[start] -= 1;
                robotIdx.add(start);
                if(durability[start]==0) zeroCnt++;
            }

            //4. 0인게 k 이상인지
            if(zeroCnt >= k) break;

        }
        System.out.println(level);
    }
}