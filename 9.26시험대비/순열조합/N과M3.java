package temp;

import java.util.Scanner;
//중복순열

public class N과M3 {
	static int n;
	static int m;
	static int[] result;
	static int[] num;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		num = new int[n];
		for(int i=1;i<=n;i++) {
			num[i-1] = i;
		}
		
		rperm(0);
		System.out.println(sb);

	}
	static void rperm(int idx) {
		if(idx == m) {
			for(int i: result) {
				sb.append(i+" ");
				//System.out.print(i+" ");-> 시간 초과 남
			}
			//System.out.println();
			sb.append("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			result[idx] = num[i];
			rperm(idx+1);
		}
	}

}
