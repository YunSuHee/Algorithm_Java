import java.util.Scanner;

class BingoPos {
	int x;
	int y;

	public BingoPos(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] bingo = new int[5][5];
		int[] row = new int[5]; // 가로줄에 체크된 숫자 counting 첫쨰줄의 카운트는 row[0]에서 둘째줄의 카운트는 row[1]에서..
		int[] col = new int[5];
		int[] diagonal = new int[2]; // diagonal[0]-> 왼쪽위에서 오른쪽 아래 //diagonal[1]-> 오른쪽 위에서 왼쪽 아래
		BingoPos[] pos = new BingoPos[26];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int n = sc.nextInt();
				bingo[i][j] = n;
				pos[n] = new BingoPos(i, j);
			}
		}
		int cnt = 0;
		for (int i = 1; i <= 25; i++) {

			int input = sc.nextInt();
			int x = pos[input].x;
			int y = pos[input].y;
			row[x]++;
			col[y]++;
			if (row[x] == 5) cnt++;
			if (col[y] == 5) cnt++;

			if (x == y) {
				diagonal[0]++;
				if (diagonal[0] == 5) cnt++;

			}
			if (x + y == 4) {
				diagonal[1]++;
				if (diagonal[1] == 5) cnt++;

			}

			if (cnt >= 3) {
				System.out.println(i);
				break;
			}

		}

	}

}
