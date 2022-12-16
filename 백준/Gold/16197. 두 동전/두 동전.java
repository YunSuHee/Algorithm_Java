import java.util.*;

public class Main {
	static int r,c;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();//행
		c = sc.nextInt();//열
		map = new int[r][c];
		sc.nextLine();
		
		int[] coinPos = new int[5];//코인들의 x,y 위치
		int arrAddPos = 0; // 배열에 추가될 위치 임시 값
		for(int i=0; i<r;i++) {
			String input = sc.nextLine();
			String[] inputArr = input.split("");
			
			for(int j=0; j<c;j++) {
				
				if(inputArr[j].equals("o")) { //동전이면 1을 넣고
					map[i][j] = 1;
					coinPos[arrAddPos] = i;//코인의 x위치
					arrAddPos+=1;
					coinPos[arrAddPos] = j;//코인의 y위치
					arrAddPos+=1;

				}else if(inputArr[j].equals(".")){ //빈칸이면 0을 넣고
					map[i][j] = 0;
				}else if(inputArr[j].equals("#")){//벽이면 2를 넣기
					map[i][j] = 2;
				}
			}
		}
		System.out.println(bfs(coinPos));
		
	
	}
	static int bfs(int[] coinPos) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(coinPos);
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[4]>=10) return -1;
			
			for(int i=0; i<4;i++) {
				
				int coin1x = now[0]+dx[i];
				int coin1y = now[1]+dy[i];
				int coin2x = now[2]+dx[i];
				int coin2y = now[3]+dy[i];
				
				//코인 떨어졌는지 확인
				boolean coin1 = false;
				boolean coin2 = false;
				
				if(coin1x<0 || coin1y<0 || coin1x>=r || coin1y>=c) {
					coin1 = true;
				}
				if(coin2x<0 || coin2y<0 || coin2x>=r || coin2y>=c) {
					coin2 = true;
				}
				//두동전 모두 떨어지면
				if(coin1 && coin2) continue;
				//한동전만 떨어지면
				if(coin1 || coin2) {
					return now[4]+1;
				}
				
				//두 동전 모두 벽을 만난다면 pass
				if(map[coin1x][coin1y] == 2 && map[coin2x][coin2y] == 2) continue;
				
				if(map[coin1x][coin1y] == 2) {
					coin1x = now[0];
					coin1y = now[1];
				}
				
				if(map[coin2x][coin2y] == 2) {
					coin2x = now[2];
					coin2y = now[3];
				}
				
				queue.add(new int[] {coin1x,coin1y,coin2x,coin2y,now[4]+1});
				
			}
			
		}
		return -1;
	}
	

}