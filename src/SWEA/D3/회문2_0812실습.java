package SWEA.D3;

import java.util.Scanner;

public class 회문2_0812실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			char[][] word = new char[100][100];
			 String[][] arr = new String[100][];
			for (int i = 0; i < 100; i++) {
				String row = sc.next();
				for (int j = 0; j < 100; j++) {
					word[i][j] = row.charAt(j);
					arr[i] = sc.next().split("");
				}
			}

			int max = 0;
			for (int i = 0; i < 100; i++) {
				for (int a = 1; a <= 100; a++) {// 회문의 길이
					for (int j = 0; j < 100 - a + 1; j++) { // 한줄에서 나올 수 있는 글자 수
						String tempRow = "";
						String tempCol = "";
						for (int k = j; k < j + a; k++) {// 글자수
							tempRow += word[i][k];
							tempCol += word[k][i];
						}
						StringBuffer sb = new StringBuffer(tempRow);
						String reverseRow = sb.reverse().toString();
						if (tempRow.equals(reverseRow) && max < a) {
							max = a;
							break;
						}

						StringBuffer sb2 = new StringBuffer(tempCol);
						String reverseCol = sb2.reverse().toString();
						if (tempCol.equals(reverseCol) && max < a) {
							max = a;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);

		}

	}

}
