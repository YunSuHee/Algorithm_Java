import java.util.Scanner;

public class Main {
	static int[][] sudoko;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		sudoko = new int[9][9]; // 스도쿠 배열
		// ArrayList<blank> list = new ArrayList<blank>(); //빈칸인곳 좌표 리스트

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int val = sc.nextInt();
				sudoko[i][j] = val;

			}
		}

		findValue(0, 0);

	}

	static void findValue(int x, int y) {


		if (x == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoko[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);

		}
		
		if (y == 9) {
			findValue(x + 1, 0);
			return;
		}
		
		if (sudoko[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (possible(x, y, i)) {
					sudoko[x][y] = i;
					findValue(x, y + 1);
				}
			}
			sudoko[x][y] = 0; // 가능한게 없어서 return 돼서 온거라 값 reset
			return;
		}

		findValue(x, y + 1);

	}

	static boolean possible(int x, int y, int value) {

		// 행 확인
		for (int i = 0; i < 9; i++) {
			if (sudoko[x][i] == value) {
				return false;
			}
		}

		// 열 확인
		for (int i = 0; i < 9; i++) {
			if (sudoko[i][y] == value) {
				return false;
			}
		}

		// 9칸 확인
		int r = x / 3;
		int c = y / 3;
		for (int i = r * 3; i < r * 3 + 3; i++) {
			for (int j = c * 3; j < c * 3 + 3; j++) {
				if (sudoko[i][j] == value) {
					return false;
				}
			}
		}

		return true;
	}

}
