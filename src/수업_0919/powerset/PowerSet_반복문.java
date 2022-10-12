package 수업_0919.powerset;

import java.util.Arrays;

public class PowerSet_반복문 {
	public static void main(String[] args) {
		int N = 4;
		int[] sel = new int[4];

		for (int i = 0; i < 2; i++) {
			sel[0] = i;
			for (int j = 0; j < 2; j++) {
				sel[1] = j;
				for (int k = 0; k < 2; k++) {
					sel[2] = k;
					for (int l = 0; l < 2; l++) {
						sel[3] = l;
						System.out.println(Arrays.toString(sel));
					}
				}
			}
		}
	}
}


