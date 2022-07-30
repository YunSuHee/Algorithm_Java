package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 방배정_13300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 한 방에 배정할 수 있는 최대 인원

		int room = 0;
		int[][] student = new int[2][6];
		
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt(); // 성별 0:여자 1: 남자
			int Y = sc.nextInt(); // 학년
			student[S][Y-1] +=1;

		}
	//	System.out.println(Arrays.deepToString(student));
		for(int i=0;i<2;i++) {
			for(int j=0;j<6;j++) {
				if( student[i][j] != 0 ) {
					if(student[i][j]% K ==0) {
						room+= student[i][j]/K;
					}else {
						room+= student[i][j]/K+1;						
					}
				}
			}
		}
		System.out.println(room);

	}

}
