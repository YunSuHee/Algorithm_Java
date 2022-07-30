package SWEA.D2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] fly = new int[n][n];
			int[] a = new int[3];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n;j++) {
					fly[i][j]= sc.nextInt();
					
				}
			}
			
//			System.out.println(Arrays.deepToString(fly));
			//+모양으로 움직이는 arr 만들
			int[] plus_dx = new int[4*(m-1)+1];
			int[] plus_dy = new int[4*(m-1)+1];
			plus_dx[0] =0;plus_dy[0] =0;
			for(int i=0; i< m-1; i++) { //2바퀴
				
				plus_dx[4*i+1] = (i+1)*0; 
				plus_dx[4*i+2] = (i+1)*0;
				plus_dx[4*i+3] = (i+1)*1;
				plus_dx[4*i+4] = (i+1)*-1;
				
				plus_dy[4*i+1] = (i+1)*1; 
				plus_dy[4*i+2] = (i+1)*-1;
				plus_dy[4*i+3] = (i+1)*0;
				plus_dy[4*i+4] = (i+1)*0;
			
		}
			
			//*모양으로 움직이는 arr 만들기
			int[] mul_dx = new int[4*(m-1)+1];
			int[] mul_dy = new int[4*(m-1)+1];
			mul_dx[0] =0;mul_dy[0] =0;
			for(int i=0; i< m-1; i++) { //2바퀴
				
				mul_dx[4*i+1] = (i+1)*1; 
				mul_dx[4*i+2] = (i+1)*1;
				mul_dx[4*i+3] = (i+1)*-1;
				mul_dx[4*i+4] = (i+1)*-1;
				
				mul_dy[4*i+1] = (i+1)*1; 
				mul_dy[4*i+2] = (i+1)*-1;
				mul_dy[4*i+3] = (i+1)*1;
				mul_dy[4*i+4] = (i+1)*-1;
			
		}
			
			// + 모양 체크
			int max =0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n;j++) {
					int sum =0;
					for(int k=0; k<plus_dx.length;k++) {
						int dx = i+plus_dx[k];
						int dy = j+plus_dy[k];
						
						if(dx <0 || dy<0 || dx>=n || dy>=n) {
							continue;
						}
						sum+=fly[dx][dy];
												
					}
					max = Math.max(max, sum);
				}
			}
			// * 모양 체크
			for(int i=0; i<n; i++) {
				for(int j=0; j<n;j++) {
					int sum =0;
					for(int k=0; k<mul_dx.length;k++) {
						int dx = i+mul_dx[k];
						int dy = j+mul_dy[k];
						
						if(dx <0 || dy<0 || dx>=n || dy>=n) {
							continue;
						}
						sum+=fly[dx][dy];
												
					}
					max = Math.max(max, sum);
				}
			}
			System.out.println("#"+t+" "+max);
		}
	}
}
