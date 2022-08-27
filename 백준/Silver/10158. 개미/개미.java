import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int w = sc.nextInt(); 
		int h = sc.nextInt();
		int p = sc.nextInt();
		int q = sc.nextInt(); 

		int t = sc.nextInt(); 


		int x = 0;
		int y = 0;

		x = (p + t) % (w*2);
		y = (q + t) % (h*2);
		

		if(x>=w) {
			x = 2*w - x;
		}
		
		if(y>=h) {
			y = 2*h - y;
		}
		
	
		System.out.println(x + " " + y);
		
//		int[][] board = new int[h+1][w+1];
//		
//		int[][] dir = {{1,1},{-1,1},{1,-1},{-1,-1}}; //방향 오른쪽 위, 오른쪽 아래, 왼쪽 위, 왼쪽 아래
//		int[][] order = {{0,1,2,3},{1,0,3,2},{2,3,0,1},{3,2,1,0}}; //오른쪽위일떄 이동 순서, 오른쪽 아래일 떄 이동 순서, 왼쪽 위 일떄 이동 순서, 왼쪽 아래 일때 이동 순서
//		
//		int now =0; //현재 방향
//		for(int i=1; i<=t;i++) {//t초동안 개미가 이동한 좌표
//			for(int j: order[now]) {
//				int dx = x+ dir[j][0]; //가로로 이동하는 좌표
//				int dy = y+ dir[j][1]; //세로로 이동하는 좌표
//				
//				if(dx>=0 && dx<=w && dy>=0 && dy<=h) {// 범위에서 안 벗어 나면
//					x = dx;
//					y = dy;
//					now =j;
//					break;
//				}
//			}
//		}
//		

	}

}