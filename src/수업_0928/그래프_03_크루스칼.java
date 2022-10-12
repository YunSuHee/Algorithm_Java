package 수업_0928;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 그래프_03_크루스칼 {
	static int[] p; // 대표를 저장할 배열

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // V : 정점의 개수 0부터 시작을 하더라
		int E = sc.nextInt(); // E : 간선의 수

		// 간선의 배열을 저장하기 위해서
		int[][] edges = new int[E][3];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt(); // [0] 시작정점
			edges[i][1] = sc.nextInt(); // [1] 도착정점
			edges[i][2] = sc.nextInt(); // [2] 가중치
		} // 입력이 끝났다.

		// 크루스칼을 만들기 위해서 무엇을 첫번쨰로 해야하나.
		Arrays.sort(edges, new Comparator<int[]>() {
			// [2] 값이 가중치 였으므로
			// 음수 / 양수+0 에 따라 값을 바꿀지 말지 결정을 한다.
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		p = new int[V]; // 대표를 저장할 친구
		// make-set을 해야겠다. (나 자신을 대표로 초기화 하자)
		for (int i = 0; i < V; i++) {
//			makeSet(i);
			p[i] = i;
		} // make-set 과정 끝

		// mst를 만들기 위해서 간선을 선택하자.
		int ans = 0;
		// 간선은 V-1를 뽑는 순간 멈춘다.
		// while 썼을때 ... for 썼을때
		int pick = 0;
		for (int i = 0; i < E; i++) {
			// i번째 간선을 뽑아서 두 정점의 대표를 확인다.
			// 대표가 같다면 pass 다르다면 union (ans 추가 pick 추가)
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			if (px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}

			if (pick == (V - 1))
				break;
		}

		System.out.println(ans);

	}// main

	private static int findSet(int x) {
		// 아무런 잔기술이 순수 그자체
//		if(x == p[x])return x;
//		return findSet(p[x]);
		// 패쓰 컴프레숀이 적용된 친구
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	private static void union(int x, int y) {
//		p[findSet(y)] = findSet(x); //교재 정석
		p[y] = x; //이번 문제는 어차피 x, y를 대표값을 넣어주므로 해도됨.
		//허나 왜 이렇게 써도 되는지를 알고 써야됨.
		
	}

	private static void makeSet(int x) {
		// rank는 따로 고려하지 않겠슴ㄴ
		p[x] = x;
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
