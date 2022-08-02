package 알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 색종이_10163 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		final int MAX_NUMBER = 1001;
		int[][] paper = new int[MAX_NUMBER][MAX_NUMBER];
		int[][] result = new int[N][4];


		for (int T = 0; T < N; T++) {
			
			for(int i=0;i<4;i++) {
				result[T][i] =sc.nextInt();
			}
			int x =result[T][0]; int y =result[T][1];
			int width =result[T][2]; int height =result[T][3];
			
			for(int i=x;i<x+width;i++) {
				for(int j=y;j<y+height;j++) {
					paper[i][j]+=1;
				}
			}
		}
		System.out.println(Arrays.deepToString(paper));
		
		//result 0번째 인덱스면 그 범위에 잇는 1만 출력 1번쨰 인덱스면 1,2 출력..
		int answer =0;
		for(int i=0;i<N; i++) {
			for(int j=result[i][0];j<result[i][0]+result[i][2];j++) {
				for(int k=result[i][1];k<result[i][1]+result[i][3];k++) {
					if(paper[j][k]>0 && paper[j][k]<=i+1) {
						answer+=1;
					}
				}
			}
			System.out.println(answer);
		}

		
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//
//		int[][] paper = new int[N][4];
//		int[] result = new int[N];
//
//		for (int t = 0; t < N; t++) {
//			for (int n = 0; n < 4; n++) {
//				paper[t][n] = sc.nextInt();
//			}
//			result[t] = paper[t][2]*paper[t][3];
//		}
//		// System.out.println(Arrays.deepToString(paper));
//		//System.out.println(Arrays.toString(result));
//		
//		for (int i = 0; i < N - 1; i++) {
//			for (int j = i + 1; j < N; j++) {
//				result[i]-=result[j];
//			}
//		}
//		for(int i:result) {
//			System.out.println(i);
//		}

	}

}
