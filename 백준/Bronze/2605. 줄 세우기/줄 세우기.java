import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> student = new ArrayList<>();
		for(int i=1;i<N+1;i++) {
			int input = sc.nextInt();
			student.add(input, i);
		}
		for(int i=N-1;i>=0;i--) {
			System.out.print(student.get(i)+" ");
		}
	}

}
