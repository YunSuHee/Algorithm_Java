package SWEA.D2;

import java.util.Scanner;

public class 간단한소인수분해 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int[] answer = {2,3,5,7,11};
		int[] result = new int[5];
		for (int i=1; i<=tc;i++) {
			int input = sc.nextInt();
			for(int j=0 ;j<answer.length;j++) {
				int temp =0;
			   while (input%answer[j]==0) {
				   input/=answer[j];
				   temp+=1;
			   }
			   result[j]=temp;
			}
			System.out.print("#"+i+" ");
			for(int k : result) {
				System.out.print(k+" ");
			}
			System.out.println();
		}

	}

}

