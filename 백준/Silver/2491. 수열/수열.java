import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 1;
		int increaseTemp = 1; 
		int decreaseTemp = 1;
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] <= arr[i]) { 
				increaseTemp++;
			} else { 
				increaseTemp = 1;
			}
			

			if (arr[i - 1] >= arr[i]) { 
				decreaseTemp++;
			} else {
				
				decreaseTemp = 1;
			}
			max = Math.max(max,Math.max(increaseTemp, decreaseTemp));
		}

		System.out.println(max);

	}

}
