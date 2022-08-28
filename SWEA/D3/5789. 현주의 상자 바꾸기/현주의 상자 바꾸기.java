import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			
			int[] arr = new int[n];
			
			for (int i = 1; i <= q; i++) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				
				for (int j = l; j <= r; j++) {
					arr[j - 1] = i;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}System.out.println();
		}

	}

}