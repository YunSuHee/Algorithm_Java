import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long answer = 0;
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        for(int i=0; i<n; i++){
            q.add(sc.nextLong());
        }

        for(int i=0; i<m; i++){
            long a = q.poll();
            long b = q.poll();
            long sum = a+b;
            q.add(sum);
            q.add(sum);
        }
        while(!q.isEmpty()){
            answer += q.poll();
        }

        System.out.println(answer);

    }
}
