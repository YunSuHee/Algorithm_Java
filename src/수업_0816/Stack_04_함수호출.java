package 수업_0816;

public class Stack_04_함수호출 {
//	static int j;
	public static void main(String[] args) {
		System.out.println("메인함수 실행");
		func1();
		//int i; 어떻게 메모리에 생기는지도 생각해보기
		System.out.println("메인함수 종료");
	}

	public static void func1() {
		System.out.println("함수1 실행");
		func2();
		System.out.println("함수1 종료");
	}

	public static void func2() {
		System.out.println("함수2 실행");
		// 작업작업작업
		System.out.println("함수2 종료");
	}
}
