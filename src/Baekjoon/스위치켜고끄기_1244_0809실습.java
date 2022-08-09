package Baekjoon;

import java.util.Scanner;

public class 스위치켜고끄기_1244_0809실습 {

	static int onoff(int n) {
		if (n == 1) {
			return 0;

		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] switch_arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			switch_arr[i] = sc.nextInt();
		}
		
		int student = sc.nextInt();
		for (int i = 0; i < student; i++) {
			int sex = sc.nextInt(); // 남학생은 1 여학생은 2
			int targetSwitch = sc.nextInt();

			if (sex == 1) {// 남자면
				for (int j = 1; j <= n; j++) {
					if (j % targetSwitch == 0) { // 배수위치에 있는 스위치 바꾸기
						switch_arr[j] = onoff(switch_arr[j]);
					}
				}
			} else { // 여자일때
				switch_arr[targetSwitch] = onoff(switch_arr[targetSwitch]);
				int sub = 1;
				while (targetSwitch-sub > 0 && targetSwitch+sub <= n) {
					if (switch_arr[targetSwitch - sub] == switch_arr[targetSwitch + sub]) {
						switch_arr[targetSwitch - sub] = onoff(switch_arr[targetSwitch - sub]);
						switch_arr[targetSwitch + sub] = onoff(switch_arr[targetSwitch + sub]);
						sub++;
					} else {
						break;
					}
				}
			}

		}
		// 출력
		for (int j = 1; j < switch_arr.length; j++) {
			System.out.print(switch_arr[j] + " ");
			if (j % 20 == 0) {
				System.out.println();
			}
		}

	}

}
