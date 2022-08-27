package 수업_0824;

public class 부분집합 {
	//모집합이 되는,, 원소들이 들어있는 배열
	static int[] arr = {3, 6, 9};
	//모집합의 원소를 골랐는지 안골랐는지를 기억할 배열
	static boolean[] check = new boolean[arr.length];
	public static void main(String[] args) {
		powerSet(0);
	}
	//idx번째 원소를 고르는 경우와 안고르는 경우로 확장
	static void powerSet(int idx) {
		//부분집합이 다 골라짐ㅇㅇ
		if( idx == arr.length ) {
			for(int i = 0; i < arr.length; i++)
				if( check[i] )
					System.out.print(arr[i] + " ");
			System.out.println();
			return;
		}
		check[idx] = true; //idx번째 원소를 고름.
		powerSet(idx + 1);
		check[idx] = false; //idx번째  원소를 안고름ㅋ
		powerSet(idx + 1);
	}
	
}
