import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}
		
		int now =1;//현재 순서
		int count =0;
		while(true) {
			if(!queue.isEmpty() &&queue.peek() == now) {
				queue.poll(); 
				now++;

			}else if(!stack.isEmpty()&& stack.peek() == now){
				stack.pop();
				now++;
			}else if(!queue.isEmpty()){
				stack.add(queue.poll());
				
			}
			if(queue.isEmpty() && stack.isEmpty()){
				System.out.println("Nice");
				break;
			}else if(count>n*2 && (!queue.isEmpty() || !stack.isEmpty())) {
				System.out.println("Sad");
				break;
			}
			count++;
		}
	}

}
