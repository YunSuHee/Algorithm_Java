package 구름;

import java.util.Scanner;

public class 폭탄구현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int total =0;
		//int[][] bomb = new int[n][n];
		int[] dx = {0,1,-1,0,0};
		int[] dy = {0,0,0,1,-1};
		for(int t=0;t<n;t++) {
			int x = sc.nextInt() -1;
			int y = sc.nextInt() -1;
			
			
			for(int i=0; i<5;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if(nx<0 || nx>=n || ny<0 || ny>=n) {
				
					continue;
				}

				//bomb[nx][ny]++;
				total++;
				
			}
			
		}
		
//		for(int i=0; i<n;i++) {
//			for(int j=0;j<n;j++) {
//				System.out.print(bomb[i][j]+ " ");
//			}System.out.println();
//		}
		
		System.out.println(total);
		
		

	}

}
