package SWEA.D3;

import java.util.Arrays;
import java.util.Scanner;

public class 상호의배틀필드_0822실습 {

	static Character[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			map = new Character[h][w];
			int startX = 0;
			int startY = 0;
			for (int i = 0; i < h; i++) {
				String line = sc.next();
				for (int j = 0; j < w; j++) {
					char target = line.charAt(j);
					map[i][j] = target;

					if (target == '^' || target == 'v' || target == '<' || target == '>') {
						startX = i;
						startY = j;
					}
				}
			}

			int n = sc.nextInt();
			String input = sc.next();
			for (int i = 0; i < n; i++) {
				char move = input.charAt(i);
			}

		}

	}
	
//	static 

}
