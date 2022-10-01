import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < n + m; i++) {
			String temp = sc.nextLine();
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 0);
			}
		}

		for (String key : map.keySet()) {
			if (map.get(key) > 0) {
				list.add(key);
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (String key : list) {
			System.out.println(key);
		}

	}

}