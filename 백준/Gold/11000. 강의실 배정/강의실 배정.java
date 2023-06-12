import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        //1. 수업 시작 시간을 기준으로 정렬을 한다.
        Arrays.sort(arr,new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[0] == o2[0]) return o1[1] - o1[1];
               return o1[0] - o2[0];
           }
        });
        // 2. 우선순위 큐에 첫번째 수업의 끝나는 시간을 저장한다.
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(arr[0][1]);

        // 3. 두번째 수업시간부터 배열을 돌며 비교한다.
        for(int i=1; i<n; i++){
            //시작하는 시간이 우선순위 큐에 있는 끝나는 시간보다 같거나 크면 우선순위 큐에 있는 끝나는 시간을 제거한다.(새로운 강의실 열필요 없음)
            if(arr[i][0] >= queue.peek()) queue.poll();
            // 현재 수업의 끝나는 시간을 우선순위 큐에 넣는다.
            queue.add(arr[i][1]);
        }
        //우선순위 큐에 남아있는 수가 필요한 강의실 수다.
        System.out.println(queue.size());

    }
}