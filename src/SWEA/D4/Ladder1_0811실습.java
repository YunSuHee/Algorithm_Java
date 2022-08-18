package SWEA.D4;

import java.util.Scanner;

public class Ladder1_0811실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			int[][] ladder = new int[100][100];
			
			//사다리 입력
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			int answer =0;

			out:for(int i=0;i<100;i++) { //사다리 시작점
					if(ladder[0][i]==0) continue;
					int x = 0;
					int y = i;
					int direction =2; // 전에 왼쪽에서 왔으면 1 오른쪽에서 왔으면 0
					while(true) {
						
						if(ladder[x][y]==2) { // 최종지점 오면 아웃
							answer = i;
							break out;
						}
						if(y+1<=99 && ladder[x][y+1] ==1 && direction != 0) { //오른쪽으로 가는 경우  전 이동에서 왼쪽으로 온게 아니어야해
							y++;
							direction =1;
						}else if(y-1>=0 && ladder[x][y-1] ==1 && direction != 1) { //왼쪽으로 가는 경우 
							y--;
							direction =0;
						}else if(x+1<=99) {//아래로 갈 경우
							x++;
							direction =2;  //아래로 가는 경우 방향 reset
						}else {
							break;
						}
					} 
			}
			
			System.out.println("#"+t+" "+answer);
			
		}

	}

}
