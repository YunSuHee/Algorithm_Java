package swea;

import java.util.Arrays;
import java.util.Scanner;

public class 회문1_0812실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int num = sc.nextInt();
			char[][] word = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String row = sc.next();
				for (int j = 0; j < 8; j++) {
					word[i][j] = row.charAt(j);
				}
			}

			int total = 0;
			for (int i = 0; i < 8; i++) { 
				for (int j = 0; j < 8-num+1; j++) { // 한줄에 나올 수 있는 글 수는 (8-찾아야하는 회문 길이 +1)개
					String tempRow="";
					String tempCol="";
					for(int k=j;k<j+num;k++) { //글자수
						tempRow+=word[i][k];
						tempCol+=word[k][i];
					}
					StringBuffer sb = new StringBuffer(tempRow);
					String reverseRow = sb.reverse().toString();
					if(tempRow.equals(reverseRow)) total++;
					
					StringBuffer sb2 = new StringBuffer(tempCol);
					String reverseCol = sb2.reverse().toString();
					if(tempCol.equals(reverseCol)) total++;
				}
			}
			
			System.out.println("#"+t +" "+total);

		}

	}

}
