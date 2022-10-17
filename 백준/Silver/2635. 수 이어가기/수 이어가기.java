
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		// 최종 출력될 리스트;
		ArrayList<Integer> result = new ArrayList<>();
		
		int maxNum =0;
		for (int i = input; i > 0; i--) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(input);
			temp.add(i);
//			System.out.println("i"+i);
			for(int j =0; j<temp.size()-1;j++) {
//				System.out.println("j"+j);
				if(temp.get(j)-temp.get(j+1)>=0) {
					temp.add(temp.get(j)-temp.get(j+1));
				}
			}
			
			if(temp.size()>maxNum) {
				maxNum = temp.size();
				//temp 리스트를 result 리스트로 복사해 근데 기존 리스트 초기화하고
				result.clear();
				result = (ArrayList<Integer>) temp.clone();
			}

			
		}
		System.out.println(maxNum);
		for(int i: result) {
			System.out.print(i+" ");
		}

	}

}
