import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		int[] col = new int[1001];

		int first = 1000; // for문 시작점
		int last = 0; // for문 끝점
		int high = 0; // 높은 빌딩
		int highplace = 0; // 제일 높은 위치
		for (int i = 0; i < input; i++) {
			int place = sc.nextInt();
			int height = sc.nextInt();
			col[place] = height;
			first = Math.min(first, place);
			last = Math.max(last, place);
			if (high < height) {
				high = height;
				highplace = place;
			}
		}

		int tempHeight = col[first];
		int tempPlace = first;

		int answer = 0;
		// 앞에서부터 최고지점까지 넓이
		for (int i = first + 1; i <= highplace; i++) {
			if (col[i] != 0 && col[i] >= tempHeight) {
				answer += (i - tempPlace) * tempHeight;
				tempHeight = col[i];
				tempPlace = i;

			}
		}

		// 뒤에서부터 최고지점까지 넓이
		tempHeight = col[last];
		tempPlace = last;
		for (int i = last - 1; i >= highplace; i--) {
			if (col[i] != 0 && col[i] >= tempHeight) {
				answer += (tempPlace - i) * tempHeight;
				tempHeight = col[i];
				tempPlace = i;

			}
		}
		// 제일 높은 빌딩 더해주기
		answer += high;

		System.out.println(answer);

	}

}