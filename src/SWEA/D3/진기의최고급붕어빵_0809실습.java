package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class 진기의최고급붕어빵_0809실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt(); //n명
			int m = sc.nextInt(); //m초의 시간동안
			int k = sc.nextInt(); //k개를 만들수있다.
			int[] time = new int[n]; //손님이 오는 시간 담는 배열

			for (int i = 0; i < n; i++) {
				time[i] = sc.nextInt();
			}
			Arrays.sort(time); //시간 sort
			
			Boolean result = true;
			for (int i = 0; i < n; i++) {
				int check = time[i] / m; //손님이 온 시간까지 만들 수 있는 빵의 개수
				if (check == 0) {
					result = false;
					break;
				} else if (check * k > i) { //지금까지 만들 수 있는 빵의 개수가 손님 차례(i)보다 많아야 true
					continue;
				} else {
					result = false;
					break;
				}
			}

			if (result) {
				System.out.println("#" + t + " Possible");
			} else {
				System.out.println("#" + t + " Impossible");
			}
		}
	}

}
