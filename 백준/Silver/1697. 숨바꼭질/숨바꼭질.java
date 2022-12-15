import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, k;
	static int[] check = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();

		if (n >= k) {
            System.out.println(n - k);
        } else {
        	bfs();
        }

	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		check[n] = 0;

		while (!queue.isEmpty()) {

			int pos = queue.poll(); // 현재 위치
			

			if (pos == k) {
				System.out.println(check[pos]);
				System.exit(0);
			}
			if (pos - 1 > 0 && check[pos - 1] == 0) {
				queue.add(pos - 1);
				check[pos - 1] = check[pos]+1;
			}
			if (pos + 1 < 100001 && check[pos + 1] == 0) {
				queue.add(pos + 1);
				check[pos + 1] = check[pos]+1;
			}
			if (pos * 2 < 100001 && check[pos * 2] == 0) {
				queue.add(pos *2);
				check[pos *2] = check[pos]+1;
			}

		}

	}

}