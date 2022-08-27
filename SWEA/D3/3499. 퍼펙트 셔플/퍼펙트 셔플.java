import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();

			Queue<String> queue = new LinkedList<>();
			String[] input = new String[n];
			for (int j = 0; j < n; j++) {
				input[j] = sc.next();
			}

			if (n % 2 == 0) {

				for (int j = 0; j < n / 2; j++) {
					queue.add(input[j]);
					queue.add(input[j + (n / 2)]);

				}
			}else {
				for (int j = 0; j < n / 2; j++) {
					queue.add(input[j]);
					queue.add(input[j + (n / 2)+1]);

				}
				queue.add(input[(n/2)]);
			}

			System.out.print("#" + i + " ");
			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");

			}
			System.out.println();
		}

	}

}