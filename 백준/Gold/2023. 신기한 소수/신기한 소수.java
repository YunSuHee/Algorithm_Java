import java.util.Scanner;

public class Main {

	static int n;
	static int[] prime;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		prime = new int[n];
		isStrangePrime(0);

	}

	static void isStrangePrime(int cnt) {
		// System.out.println(Arrays.toString(prime));
		// 기저조건
		if (cnt == n) {

			for (int i : prime) {
				System.out.print(i);
			}
			System.out.println();
			return;
		}
		//지금까지 통과된 값 담을 변수
		int check = 0;
		//자릿수 check 변수
		int temp = cnt;
		//지금까지 통과된 값 넣기
		for (int j = 0; j < cnt; j++) {
			check += prime[j] * Math.pow(10, temp);
			temp--;
		}

		for (int i = 1; i <= 9; i++) {
			// 만약 소수면
			if (isPrime(check + i)) {
				// 배열에 값 넣어주고
				prime[cnt] = i;
				// cnt 증가 해주고
				isStrangePrime(cnt + 1);

			}
		}

	}

	static boolean isPrime(int input) {
		if (input < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(input); i++) {
			if (input % i == 0) {
				return false;
			}
		}
		return true;
	}

}