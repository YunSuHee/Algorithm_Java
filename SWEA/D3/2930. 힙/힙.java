import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
			System.out.print("#" + tc + " ");
			int N = sc.nextInt();

			for (int i = 0; i < N; i++) {
				if (sc.nextInt() == 1) {
					priorityQueue.add(sc.nextInt());
				} else if (!priorityQueue.isEmpty()) {
					System.out.print(priorityQueue.poll() + " ");
				} else {
					System.out.print(-1 + " ");
				}
			}
			System.out.println();
		}

	}

}