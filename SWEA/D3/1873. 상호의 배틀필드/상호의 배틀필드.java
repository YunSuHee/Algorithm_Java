import java.util.Scanner;

public class Solution {
	static char[][] map;
	static int x;
	static int y;
	static int H;
	static int W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();
			sc.nextLine();

			map = new char[H][W];

			int[] dx = { -1, 1, 0, 0 };// 위, 아래, 좌, 우
			int[] dy = { 0, 0, -1, 1 };
			int dir = 0;
			x = 0;
			y = 0;
			// 배열에 맵 저장, 시작점,방향 저장
			for (int i = 0; i < H; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);

					if (line.charAt(j) == '^') {
						x = i;
						y = j;
						dir = 0;
					} else if (line.charAt(j) == 'v') {
						x = i;
						y = j;
						dir = 1;
					} else if (line.charAt(j) == '<') {
						x = i;
						y = j;
						dir = 2;
					} else if (line.charAt(j) == '>') {
						x = i;
						y = j;
						dir = 3;
					}
				}
			}

			// 명령어 수
			int moveLine = sc.nextInt();
			sc.nextLine(); // 다음 문자를 받으려면 뒤에 \n 이거 처리 해줘야해
			String line = sc.nextLine();
			for (int i = 0; i < moveLine; i++) {
				switch (line.charAt(i)) {
				case 'U':
					dir = 0;
					move(dir, dx[dir], dy[dir], '^');
					break;
				case 'D':
					dir = 1;
					move(dir, dx[dir], dy[dir], 'v');
					break;
				case 'L':
					dir = 2;
					move(dir, dx[dir], dy[dir], '<');
					break;
				case 'R':
					dir = 3;
					move(dir, dx[dir], dy[dir], '>');
					break;
				case 'S':
					shoot(dir, dx[dir], dy[dir]);
					break;

				}
			}

			// 출력
			System.out.print("#" + tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		}

	}

	static void move(int dir, int rx, int ry, char sign) {
		int nx = x + rx;
		int ny = y + ry;

		if (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
			map[x][y] = '.';
			map[nx][ny] = sign;
			x = nx;
			y = ny;
		} else {
			map[x][y] = sign;
		}
	}

	static void shoot(int dir, int rx, int ry) {
		int nx = x + rx;
		int ny = y + ry;
		while (nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] != '#') {// 벗어나거나 #을 만나기 전까지
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
                break;
			}
			nx += rx;
			ny += ry;
		}
	}

}