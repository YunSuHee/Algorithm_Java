import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int last =0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i=1; i<=n; i++) {
        	queue.offer(i);
        }
        while(queue.size()!=1) {
        	queue.poll();
        	int back= queue.peek();
        	queue.offer(back);
        	queue.poll();
        }
        System.out.println(queue.peek());
    }
}