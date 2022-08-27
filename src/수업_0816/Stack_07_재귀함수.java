package 수업_0816;

public class Stack_07_재귀함수 {
	static int cnt = 0;

	public static void main(String[] args) {
//		func1();
		func2(-5);
	}// main

	// 얘는 종료가 될까????
	public static void func1() {
		// 메모리가 무한정이라면
		// 무한히 출력이되는게 맞는데...
		// 그러나, 메모리에 한계가 있기 떄문에 스택이 흘러넘쳐 종료가 된다.
//		System.out.println("함수 호출");
		System.out.println(cnt++);
		func1();
	}

	// 재귀 함수는 크게 2부분으로 구성이 된다.
	// 1. 기본파트 : 재귀함수를 종료하는 조건
	// 2. 재귀파트 : 나 자신을 다시 부르는 부분
	public static void func2(int n) {
		// 베이스케이스 : 조건을 작성하는것은 문제를 잘 살펴보고 여러분들이 적어야 한다.
		if (n <= 0) {
//			System.out.println("n은 0이야");
			return;
		}
		System.out.println(n);
		func2(n - 1);

	}
}
