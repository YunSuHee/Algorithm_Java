import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int line = Integer.parseInt(br.readLine());
		boolean[] agg = new boolean[21]; // x가 1부터 20까지
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < line; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			int n = 0;
			if (st.hasMoreTokens()) {
				n = Integer.parseInt(st.nextToken());
			}

			switch (input) {
			case "add":
				agg[n] = true;
				break;
			case "remove":
				agg[n] = false;
				break;
			case "check":
				if (agg[n])
					sb.append("1\n");
				else
					sb.append("0\n");

				break;
			case "toggle":
				if (agg[n])
					agg[n] = false;
				else
					agg[n] = true;

				break;
			case "all":
				Arrays.fill(agg, true);
				break;
			case "empty":
				Arrays.fill(agg, false);
				break;
			}
		}
		
		System.out.println(sb.toString());
	}

}