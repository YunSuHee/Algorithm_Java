import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Guest{
	int nowx;
	int nowy;
	int arrivex;
	int arrivey;
	
	public Guest(int nowx, int nowy, int arrivex, int arrivey) {
		super();
		this.nowx = nowx;
		this.nowy = nowy;
		this.arrivex = arrivex;
		this.arrivey = arrivey;
	}
	
	
}
public class Main {
	static int n,m,fuel;
	static int[][] road;
	static int taxix,taxiy;
	static ArrayList<Guest> guest;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		fuel = sc.nextInt();
		road = new int[n][n];
		
		for(int i=0; i<n;i++) {
			for(int j=0;j<n;j++) {
				road[i][j]= sc.nextInt();
			}
		}
		
		taxix = sc.nextInt()-1; //taxi x 위치
		taxiy = sc.nextInt()-1; //taxi x 위치
		
		//guest 위치와 목표 지점 저장 배열
		guest = new ArrayList<>();
		
		//guest 위치와 목표 지점 배열에 추가하기
		for(int i=0; i<m;i++) { 
			int startx = sc.nextInt()-1;
			int starty = sc.nextInt()-1;
			int endx = sc.nextInt()-1;
			int endy = sc.nextInt()-1;
			guest.add(new Guest(startx,starty,endx,endy));
		}
		
		//손님 수 만큼 택시 이동
		int firstguestnum = m; //나중엔 guest 수가 바뀜
		for(int i=0; i<firstguestnum;i++) {
			findGuest();			
			
		}
		
		System.out.println(fuel);
		
	}
	private static void findGuest() {
		
		int shortest = Integer.MAX_VALUE;
		int shorttestguestidx = -1;
		
		for(int i=0; i<m;i++) {
			int nowx = guest.get(i).nowx;
			int nowy = guest.get(i).nowy;
			
			int starttoguest = bfs(nowx,nowy);
			if(starttoguest == -1) { //손님을 이동할 수 없는 경우
				System.out.println(-1);
				System.exit(0);
			}
			if(shortest >=starttoguest){
				if(shortest == starttoguest) {
					if(guest.get(shorttestguestidx).nowx <guest.get(i).nowx) {//기존에 있던 최단거리의 행이 더 작으면 continue
						continue;
					}else if (guest.get(shorttestguestidx).nowx == guest.get(i).nowx) {//두개 같으면 열까지 비교
						if(guest.get(shorttestguestidx).nowy < guest.get(i).nowy) {
							continue;
						}
					}
				}
				shortest = starttoguest;
				shorttestguestidx = i;
			}
		}
		int tempx = guest.get(shorttestguestidx).nowx;
		int tempy = guest.get(shorttestguestidx).nowy;
		int arrivex = guest.get(shorttestguestidx).arrivex;
		int arrivey = guest.get(shorttestguestidx).arrivey;

		//택시 위치 변경
		taxix = tempx;
		taxiy = tempy;
		fuel -= shortest; //연료 뺴기
		if(fuel<0) { //사람은 남아있는데 연료가 없으면 
			System.out.println(-1);
			System.exit(0);
		}
		//guest태우고 목적지로 가기
		int guesttoarrive = bfs(arrivex,arrivey);
		taxix = arrivex;
		taxiy = arrivey;
		fuel-=guesttoarrive; //최단 거리 뺴기
		if(fuel<0) {
			System.out.println(-1);
			System.exit(0);
		}
		m-=1; //손님 한명 빼기
		guest.remove(shorttestguestidx);//값도 지우기
		fuel+= guesttoarrive*2; //연료 2배
		
		
	}
	
	private static int bfs(int nowx, int nowy) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {taxix,taxiy,0});
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		boolean[][] check = new boolean[n][n];
		check[taxix][taxiy] = true;
		
		while(!queue.isEmpty()) {
			int[] nowPosition = queue.poll();
			int nx = nowPosition[0];
			int ny = nowPosition[1];
			int cnt = nowPosition[2];
			
			if(nx==nowx &&ny== nowy) return cnt;
			for(int i=0; i<4;i++) {
				int nextx = nx+dx[i];
				int nexty = ny+dy[i];
				if(nextx>=0 && nextx<n && nexty>=0 && nexty<n && !check[nextx][nexty] && road[nextx][nexty]!= 1) {
					check[nextx][nexty] = true;
					queue.add(new int[] {nextx,nexty,cnt+1});
				}
			}
		}
		return -1;
	}

}
