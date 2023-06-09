import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static boolean[][] virus;
	static boolean[] check;
	static int sum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n =sc.nextInt(); //정점
		m = sc.nextInt(); //간선
		
		virus = new boolean[n+1][n+1];
		check = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			virus[a][b] = true;
			virus[b][a] = true;
		}
		
		dfs(1);
		System.out.println(sum);

	}
	static void dfs(int start) {
		check[start] = true;
		
		for(int i=0; i<virus.length;i++) {
			if(virus[start][i] && check[i] == false) {
				sum+=1;
				dfs(i);
			}
		}
	}

}
