import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static <T> void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] rooms = new int[n][2];

		for (int i = 0; i < n; i++) {
			rooms[i][0] = sc.nextInt();
			rooms[i][1] = sc.nextInt();

		}

		Arrays.sort(rooms, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]; // 첫번째 기준 오름차순 > 두번째 기준 오름차순 :
																		// {1,30}{2,10}{3,50}{4,20}{5,40}{6,10}{6,20}{6,30}{6,40}{6,50}
				// return o1[0]!=o2[0] ? o1[0]-o2[0] : o2[1]-o1[1]; // 첫번째 기준 오름차순 > 두번째 기준 내림차순
				// : {1,30}{2,10}{3,50}{4,20}{5,40}{6,50}{6,40}{6,30}{6,20}{6,10}
				// 양수면 자리 바꿈

			}

		});
		//System.out.println(Arrays.deepToString(rooms));
		int temp = rooms[0][1];
		int answer = 1;
		for (int i = 1; i < n; i++) {
			if(rooms[i][0]>=temp) {
				answer+=1;
				temp = rooms[i][1];
			}
		}

		System.out.println(answer);

	}

}