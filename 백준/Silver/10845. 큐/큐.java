
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int last = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			String first = sc.next();
			
		
			if (first.equals("push")) {
				int num = sc.nextInt();
				queue.offer(num);
				last = num;
			} else if (first.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");
				}
			} else if (first.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (first.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (first.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peek()).append("\n");
				}
			} else if (first.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(last).append("\n");
				}
			}
		}
		
		System.out.println(sb.toString());
	}
}