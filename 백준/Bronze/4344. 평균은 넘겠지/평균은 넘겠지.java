import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for (int t = 0; t < c; t++) {
			int n = sc.nextInt();
			int[] student = new int[n];
			int total = 0;
			for (int i = 0; i < n; i++) {
				int value = sc.nextInt();
				student[i] = value;
				total += value;
			}
			int avg = total / n;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (student[i] > avg) {
					cnt++;
				}
			}

			double stu = cnt/(double)n*100 ;
			System.out.printf("%.3f%s\n",stu,"%");


		}

	}

}
