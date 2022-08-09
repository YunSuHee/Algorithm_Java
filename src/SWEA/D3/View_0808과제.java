package SWEA.D3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class View_0808과제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int testcase = sc.nextInt();
			int[] arr = new int[testcase];
			for (int i = 0; i < testcase; i++) {
				arr[i] = sc.nextInt();
			}
			int[] result = new int[4];
			int answer =0;
			for (int i = 2; i < testcase - 2; i++) {
				result[0]=arr[i] - arr[i + 1];  // 오른쪽 첫번째 건물
				result[1]= arr[i] - arr[i + 2]; // 오른쪽 첫번째 건물
				result[2]= arr[i] - arr[i - 1]; //왼쪽 첫번째 건물
				result[3]= arr[i] - arr[i - 2]; //왼쪽 두번째 건물
				
				
				if (result[0] > 0 && result[1] > 0 && result[2] > 0 && result[3] > 0) {
					Arrays.sort(result);
					answer+=result[0];
				}
			}
			System.out.printf("#%d %d\n",tc,answer);
		}

	}

}
