package Baekjoon;

import java.util.Scanner;

public class 계단오르기_2579 {
	static int[] dpCheck;
	static int[] floorNum;
	static int answer =0;
	static int n;
	public static void main(String[] args) {
		//1.오를수 있는 계단  한칸  or 두칸
		//2.한칸씩 3번은 안됨
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dpCheck = new int[n];
		floorNum = new int[n];
		
		for(int i=0;i<n;i++) {
			floorNum[i] = sc.nextInt();
		}
		
		floors(0,1,0,true);
		
		System.out.println(answer);

	}
	
	static void floors(int now ,int space, int result , boolean check) {//현재 위치, 올라간 계단 수 (1또는 2), 더해진 값
		dpCheck[now] =floorNum[now]+result;
		if(now == n-1) {
			result+= floorNum[now];
			if(result > answer) {
				answer = result;
			}
			return;
		}
		
		if(space == 1 && check == false) {
			//올라갈 계단 2
			if(now+2 <n && dpCheck[now+2]<result+floorNum[now+2]) { // now+2 가 n보다 큰경우 dpCheck[now+2]하면 인덱스 오류가 나기 때문에 now+2<n을 먼저 적어줘야함				
					floors(now+2,2,result+floorNum[now]);
			}
			return;
		}else {
			//올라갈 계단 1 또는 2
			if(now+1 <n && dpCheck[now+1]<result+floorNum[now+1]) {				
				floors(now+1,1,result+floorNum[now]);
			}
			
			if(now+2 <n && dpCheck[now+2]<result+floorNum[now+2]) {				
				floors(now+2,2,result+floorNum[now]);
			}

			return;
			
		}

	}

}
