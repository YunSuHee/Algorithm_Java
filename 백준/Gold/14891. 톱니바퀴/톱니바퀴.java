import java.util.Scanner;

public class Main {
	static int[][] gear;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		gear = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String line = sc.nextLine();
			for (int j = 0; j < 8; j++) {
				gear[i][j] = line.charAt(j) - '0';
			}
		}

		int n = sc.nextInt(); // 회전 수

		for (int i = 0; i < n; i++) {
			int startGear = sc.nextInt();
			int direction = sc.nextInt();
			int[] gearDirection = new int[4];

			// 시작기어 방향값 넣기
			gearDirection[startGear - 1] = direction;

			// 기아의 방향 정하기
			if (startGear == 1) {// 오른쪽만 확인
				// 맞닿은 부분이 다를때
				// 1과 2
				if (gear[0][2] != gear[1][6]) {
					gearDirection[1] = gearDirection[0] * -1;

				}
				// 2와 3
				if (gearDirection[1] != 0 && gear[1][2] != gear[2][6]) {
					gearDirection[2] = gearDirection[1] * -1;

				}
				// 3와 4
				if (gearDirection[2] != 0 && gear[2][2] != gear[3][6]) {
					gearDirection[3] = gearDirection[2] * -1;

				}
			} else if (startGear == 2) {
				// 2와 3
				if (gear[1][2] != gear[2][6]) {
					gearDirection[2] = gearDirection[1] * -1;
				}
				// 2와 1
				if (gear[1][6] != gear[0][2]) {
					gearDirection[0] = gearDirection[1] * -1;
				}
				// 3과 4
				if (gearDirection[2] != 0 && gear[2][2] != gear[3][6]) {
					gearDirection[3] = gearDirection[2] * -1;
				}
			} else if (startGear == 3) {// 왼쪽만 확인
				// 3과 4
				if (gear[2][2] != gear[3][6]) {
					gearDirection[3] = gearDirection[2] * -1;
				}
				// 3과 2
				if (gear[2][6] != gear[1][2]) {
					gearDirection[1] = gearDirection[2] * -1;
				}
				// 2와 1
				if (gearDirection[1] != 0 && gear[1][6] != gear[0][2]) {
					gearDirection[0] = gearDirection[1] * -1;
				}
			} else {
				// 4와3
				if (gear[3][6] != gear[2][2]) {
					gearDirection[2] = gearDirection[3] * -1;
				}
				// 3과 2
				if (gearDirection[2] != 0 && gear[2][6] != gear[1][2]) {
					gearDirection[1] = gearDirection[2] * -1;
				}
				// 2와 1
				if (gearDirection[1] != 0 && gear[1][6] != gear[0][2]) {
					gearDirection[0] = gearDirection[1] * -1;
				}
			}

			moveGear(gearDirection);

		}
		
		//점수 계산
		int result = 0;
		if (gear[0][0] == 1)
			result += 1;
		if (gear[1][0] == 1)
			result += 2;
		if (gear[2][0] == 1)
			result += 4;
		if (gear[3][0] == 1)
			result += 8;
		System.out.println(result);

	}

	private static void moveGear(int[] gearDirection) {

		for (int i = 0; i < 4; i++) {
			// 회전 할게 없을때
			if (gearDirection[i] == 0) {
				continue;
			}
			// 시계 방향일 때
			if (gearDirection[i] == 1) {
				int temp[] = new int[8];
				temp[0] = gear[i][7];
				for (int j = 1; j < 8; j++) {
					temp[j] = gear[i][j - 1];

				}
				gear[i] = temp.clone();
			}
			// 반시계 방향일 때
			if (gearDirection[i] == -1) {
				int temp[] = new int[8];
				temp[7] = gear[i][0];
				for (int j = 0; j < 7; j++) {
					temp[j] = gear[i][j + 1];

				}
				gear[i] = temp.clone();
			}

		}

	}

}
