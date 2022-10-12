package SWEA.SW;

import java.util.Scanner;

public class 요리사 {
	static int n;
	static int[] check;
	static int[][] ingred;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			check = new int[n/2];
			
			ingred = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ingred[i][j] = sc.nextInt();
				}
			}
			result = Integer.MAX_VALUE;;
			
			comb(0,0);
			System.out.println("#"+tc+" "+result);
		}
		
		
	}
	static void comb(int idx, int count) { //
		if(count == n/2) {
			int sum =0;
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					sum+= ingred[check[i]][check[j]];
				}
			}
			int[] uncheck = new int[n/2];
			int index_un =0;
			int index_ch =0;
			for(int i=0;i<n;i++) {
				if (index_ch<n/2 && i == check[index_ch])
					index_ch++;
				else if(index_un<n/2 ){
					uncheck[index_un++] = i;
				}
			}
			int sum2 =0;
			for(int i=0;i<n/2;i++) {
				for(int j=0;j<n/2;j++) {
					sum2+= ingred[uncheck[i]][uncheck[j]];
				}
			}
			
			int temp = Math.abs(sum-sum2);
			if(temp <result) {
				result = temp;
			}
			return;
		}
		for(int i=idx; i<=n-n/2+count;i++) {
			check[count] = i;
			comb(i+1,count+1);
		}
		
		
	}
}

