import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int temp = i;
			while (temp % 5 == 0) {
				answer++;
				temp /= 5;
			}
		}
		System.out.println(answer);
	}
}