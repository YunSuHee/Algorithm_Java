import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            q.add(sc.nextInt());
        }
        int answer = 0;
        while(q.size() >1){
            int sum = q.poll() +q.poll();
            answer += sum;
            q.add(sum);
        }
        System.out.println(answer);

    }
}
