package SWEA.D1;

import java.util.ArrayList;
import java.util.Scanner;

public class 중간값찾기_0809실습 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc. nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		
		//선택정렬
		
		// 버블 정렬
		for(int i=0; i<N-1;i++) { // 몇회 돌지
			for(int j=1;j<N-i;j++) {
				if(list.get(j-1)>list.get(j)) {
					int temp =list.get(j-1);
					list.set(j-1,list.get(j));
					list.set(j, temp);
				}
			}
		}
		System.out.println(list.get(N/2));

	}

}
