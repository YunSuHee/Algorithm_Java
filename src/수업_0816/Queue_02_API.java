package 수업_0816;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_02_API {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();  // linkedlist에서 큐에 관련된 것만 쓸 수 있다. 

		// 추가
		queue.add(10);
		queue.offer(10);

		// 삭제  
		System.out.println(queue.remove());
//		System.out.println(queue.remove()); //empty인데 또 remove 하면 예외발생
		System.out.println(queue.poll());
//		System.out.println(queue.poll()); //empty인데 또 remove 하면 널값이 반환

		// 조회
		System.out.println(queue.element());
		System.out.println(queue.peek());

		// add, remove, element : 예외발생시킴.

		// offer, poll, peek : 값을 반환.

	}
}
