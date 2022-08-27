package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 집합_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		int[] agg = new int[21]; // x가 1부터 20까지

		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int n = 0; 
			if (st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken());
			}

			switch (input) {
			case "add":
				if (agg[n] == 0)
					agg[n]++;
				break;
			case "remove":
				if (agg[n] != 0)
					agg[n]--;
				break;
			case "check":
				if (agg[n] == 1)
					System.out.println(1);
				else
					System.out.println(0);

				break;
			case "toggle":
				if (agg[n] == 1)
					agg[n] = 0;
				else
					agg[n] = 1;

				break;
			case "all":
				Arrays.fill(agg, 1);
				break;
			case "empty":
				Arrays.fill(agg, 0);
				break;
			}
		}
	}

}
