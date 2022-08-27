package 수업_0824;

//재귀함수 : 자기 자신을 호출하는 함수.
public class 재귀함수 {
	static int[] arr = { 1, 2, 3 };
	public static void main(String[] args) {
		func(0, 0);
	}
	public static void func(int n, int sum) {
		//재귀함수의 기저
		if( n == 3 ) {
			System.out.println(sum);
			return;
		}
		
//		System.out.println(arr[n]);
		func( n + 1, sum + arr[n] );
		func( n + 1, sum );
	}
}
