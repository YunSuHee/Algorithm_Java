import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int[] comb;
	static int[] count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		comb = new int[n]; // 숫자 들어가야할 배열
		count = new int[m]; // 출력해야 할 임시 배열
		for (int i = 0; i < n; i++) {
			comb[i] = i + 1;
		}

		combination(0, 0);
	}
	
	static void combination(int idx, int cnt) {
		//탈출 조건
		if(cnt == m) {
			for(int i : count) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i= idx;i<=n-m+cnt;i++) {
			count[cnt] = comb[i];
			combination(i+1,cnt+1); // 현재 값이니 idx+1이 아닌 i+1
		}
	}

}
