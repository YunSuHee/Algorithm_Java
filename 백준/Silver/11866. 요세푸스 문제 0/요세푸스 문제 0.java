import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			queue.add(i);
		}

		int front = 0;
		System.out.print("<");
		for (int i = 0; i < N; i++) {
			front = (front + K - 1) % queue.size();
			if (i == N - 1) {
				System.out.print(queue.get(front) + ">");

			} else {

				System.out.print(queue.get(front) + ", ");
			}
			queue.remove(front);

		}

	}

}