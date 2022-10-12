import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int f, s, g, u, d;
	static int min = Integer.MAX_VALUE;
	static boolean[] check;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();
		
		check = new boolean[f+1];
		bfs();
		if (min == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(min);
		}
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { s, 0 });

		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			int stair = data[0];
			int cnt = data[1];

			if (stair == g) {
				min = cnt;
				break;
			}
			int up = stair + u;
			int down = stair - d;
			if (up <= f && u != 0 && !check[up]) {
				if(up == g) {
					min = cnt+1;
					break;
				}
				check[up] = true;
				queue.add(new int[] { up, cnt + 1 });
			}

			if (down >= 1 && d != 0 && !check[down]) {
				if(down == g) {
					min = cnt+1;
					break;
				}
				check[down] = true;
				queue.add(new int[] { down, cnt + 1 });
			}

		}

	}

}