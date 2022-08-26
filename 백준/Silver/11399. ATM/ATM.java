import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] time = new int[n];
		for(int i=0;i<n;i++) {
			time[i]=sc.nextInt();
		}
		Arrays.sort(time);

		int sum =0;
		int temp = n;
		for(int i=0;i<n;i++) {
			sum += time[i]*temp;
			temp--;
		}
		System.out.println(sum);

	}

}