import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static Map<Integer, String[]> map = new HashMap<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {

			int n = sc.nextInt();
			for (int i = 0; i <= n; i++) {
				String[] line = sc.nextLine().split(" ");
				String[] value = Arrays.copyOfRange(line, 1, line.length);
				map.put(i, value);
			}
			System.out.print("#"+t+" "); 
			re(1, map.get(1));
			System.out.println();

		}
	}

	static void re(int i, String[] arr) {
		if (arr.length == 1) {
			System.out.print(arr[0]);
		} else if (arr.length == 2) {
			re(Integer.parseInt(arr[1]), map.get(Integer.parseInt(arr[1])));
			System.out.print(arr[0]);
		} else if (arr.length == 3) {
			re(Integer.parseInt(arr[1]), map.get(Integer.parseInt(arr[1])));
			System.out.print(arr[0]);
			re(Integer.parseInt(arr[2]), map.get(Integer.parseInt(arr[2])));

		}
	}

}