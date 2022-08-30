package 전공시험;

import java.util.Scanner;

public class 도형만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		if (input == 1) {
			int a = 1;
			for(int i=0;i<4;i++) {
				for(int j=3-i;j<4;j++) {
					System.out.print(a++ +" ");
				}
				System.out.println();
			}
		}else if("A".equals(input)) {
			for(int i=0;i<5;i++) {
				
			}
		}

	}

}
