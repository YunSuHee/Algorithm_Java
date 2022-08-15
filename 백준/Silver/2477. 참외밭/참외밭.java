import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int fruit = sc.nextInt();

		int[][] field = new int[6][2];

		for (int i = 0; i < 6; i++) {
			field[i][0] = sc.nextInt();
			field[i][1] = sc.nextInt();
		}
		int maxEW = 0;
		int maxNS = 0;
		int minval = 1;


		for (int i = 0; i < 6; i++) {
			if (field[i][0] == 1 || field[i][0] == 2) {
				maxEW = Math.max(maxEW, field[i][1]);
			} else {
				maxNS = Math.max(maxNS, field[i][1]);
			}
			
			if(field[i][0] == field[(i+2)%6][0]) {
				minval *= field[(i+1)%6][1];
			}
		}

		int rec = maxEW * maxNS - minval;
		System.out.println(rec * fruit);

	}

}
