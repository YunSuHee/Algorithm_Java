import java.io.IOException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());

//		int t = Integer.parseInt(st.nextToken());
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
//			String word = st.nextToken();
			String word = "0"+sc.nextLine();
			int result = 0;

			for(int i=0;i<word.length()-1;i++) {
				if(word.charAt(i)!=word.charAt(i+1)) {
					result++;
				}
			}
			

			System.out.println("#" + tc + " " + result);
		}

	}

}