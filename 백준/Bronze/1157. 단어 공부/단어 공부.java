import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next().toUpperCase();

		int[] arr = new int[26]; // 알파벳은 26개
		for (int i = 0; i < word.length(); i++) {
			int now = (int) word.charAt(i);
			arr[now - 65]++; // A 아스키 코드 는 65
		}
		int max = 0;
		int temp = 0;
		boolean check = false;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				temp = i;
				check = false;
			} else if (max == arr[i]) {
				check = true;
			}
		}

		if (check) {
			System.out.println("?");
		} else {
			System.out.println((char) (65 + temp));
		}

	}

}