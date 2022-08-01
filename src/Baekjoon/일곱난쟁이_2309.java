package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱난쟁이_2309 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] small = new int[9];
		int total =0;
		for(int i=0;i<9;i++) {
			small[i]=sc.nextInt();
			total+=small[i];
		}
		int x = 0,y =0;
		out :
		for(int i=0; i<8;i++) {
			for(int j=i+1;j<9;j++) {
				if(total - small[i]-small[j] == 100) { //9난쟁이 모두 던한 수에서 2명 난쟁이를 뻈을때 100이 되는 경우를 찾음
					x=i;y=j;
					break out;
				}
			}
		}
		
		List<Integer> temp = new ArrayList();
		
		for(int i=0;i<9;i++) {
			if(i==x || i==y) {
				continue;
			}else {
				temp.add(small[i]);
			}
		}
		
		Collections.sort(temp);
		for(int i :temp) {
			System.out.println(i);
		}
		
		

	}

}
