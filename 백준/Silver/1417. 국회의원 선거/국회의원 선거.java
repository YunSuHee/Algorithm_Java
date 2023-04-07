import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dasom = sc.nextInt();
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<n; i++){
           q.add(sc.nextInt());
        }
        while(!q.isEmpty() && dasom <= q.peek() ){
            int minus = q.poll() - 1;
            dasom++;
            q.add(minus);
            answer++;
        }
        System.out.println(answer);

    }



}
