import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<Integer,Integer> ladderandsnake = new HashMap<>();

        for(int i=0;i<n+m;i++){
            ladderandsnake.put(sc.nextInt(),sc.nextInt());
        }

        int[] visited = new int[101];

        Queue<Integer> q = new LinkedList<>();
        //첫번째 주사위 굴렸을때 들어 갈 수 있는 수
        q.add(1);

        while(!q.isEmpty()){

            int now = q.poll();
            if(now == 100){
                System.out.println(visited[100]);
                break;
            }

            for(int i=1; i<=6; i++){

                //다음 이동할 값
                int nextPos = now+i;

                //100 넘어가면 skip
                if(nextPos>100) continue;

                //이미 방문한 적 있으면 skip
                if(visited[nextPos]!=0) continue;
                //뱀이나 사다리 만나 nextPos 업데이트 하기 전 위치도 방문 표시
                visited[nextPos] = visited[now]+1;
                //뱀이나 사다리를 만나면 q에 nextPos를 넣어야 한다.
                if(ladderandsnake.containsKey(nextPos)){

                    //다음 위치 뱀이나 사다리 타고 이동한 위치로 업데이트
                    nextPos = ladderandsnake.get(nextPos);
                    //방문
                    if(visited[nextPos] ==0) visited[nextPos] = visited[now]+1;
                }

                q.add(nextPos);
            }

        }
    }

}
