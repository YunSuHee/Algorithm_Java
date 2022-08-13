package Baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class 색종이2_2567 {

	public static void main(String[] args) {
		// 라인일 경우(i나 j 둘중 하나가 0이나 9) 2 내용일 경우 1로 채우고 //라인 인덱스 값에 0 이거나 9 이면 2가 되고 1이면 1 //두번쨰 색종이가 라인을 입력할때 기존에 있던 영역이면(paper[i][j]==1 ) 라인을 입력하지 않고 continue

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		int[][] paper = new int[100][100];
//		for(int t =0; t<tc;t++) {
//			int x = sc.nextInt();//3
//			int y = sc.nextInt();//7
//			System.out.println();
//			for(int i=0;i<10;i++) {
//				for(int j=0;j<10;j++) {
//					if(i==0 ||j==0 || i==9 || j==9) {
//						if(paper[x+i][y+j] ==0)  // 기존 값이 1 이거나 2 이면 겹치는 부분이니까
//						   paper[x+i][y+j] =2;
//						else if(paper[x+i][y+j] ==2) paper[x+i][y+j] =1;
//					}else {
//						paper[x+i][y+j] =1;
//					}
//				}
//			}
//
//		}
//		int cnt =0;
//		for(int i=0;i<101;i++) {
//			for(int j=0;j<101;j++) {
//				if(paper[i][j]==2) {
//					cnt++;
//				}
//				
//			}
//		}

		//System.out.println(cnt);

	}

}
