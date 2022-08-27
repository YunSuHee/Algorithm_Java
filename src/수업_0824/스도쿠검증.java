package 수업_0824;

public class 스도쿠검증 {
	public static void main(String[] args) {

	}

	static int[][] arr;

	static int check() {
		// 모든 행에서 중복이 있는지 검사
		for (int i = 0; i < 9; i++) {
			boolean[] check = new boolean[10];
			for (int j = 0; j < 9; j++) {
				// 중복이 발견 되면 return 0;
				if (check[arr[i][j]])
					return 0;
				check[arr[i][j]] = true;
			}
		}
		// 모든 열에서 중복이 있는지 검사
		for (int j = 0; j < 9; j++) {
			boolean[] check = new boolean[10];
			for (int i = 0; i < 9; i++) {
				// 중복이 발견 되면 return 0;
				if (check[arr[i][j]])
					return 0;
				check[arr[i][j]] = true;
			}
		}
		//격자판
		for(int i = 0; i < 9; i += 3 ) {
			for(int j = 0; j < 9; j += 3) {
				//i,j가 각각 격자박스의 시작점
				boolean[] check = new boolean[10];
				for(int m = 0; m < 3; m++) {
					for(int n = 0; n < 3; n++) {
						if( check[ arr[i+m][j+n] ] )
							return 0;
						check[ arr[i+m][j+n] ] = true;
					}
				}
			}
		}
		return 1;
	}
}




