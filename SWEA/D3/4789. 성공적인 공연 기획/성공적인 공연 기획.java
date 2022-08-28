import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		for (int t = 1; t <= tc; t++) {
			String line = sc.nextLine();
			int result = line.charAt(0) - '0';
			int add = 0;// 더 필요한 사람 수
			if (line.length() == 1 && result == 0) {
				add = 1;
			}
			for (int i = 1; i < line.length(); i++) {
				int person = line.charAt(i) - '0';
				if (person != 0) {
					if (i > result) {
						add += i - result;
						result += i - result;
					}

					result += person;

				}
			}
			System.out.println("#" + t + " " + add);
		}

	}

}