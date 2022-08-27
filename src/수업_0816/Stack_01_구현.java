package 수업_0816;

public class Stack_01_구현 {
	static int[] stack = new int[10];
	static int top = -1; //마지막 원소를 가리키는 변수
	
	
	public static void main(String[] args) {
		// 배열을 이용하여 스택을 만들어보고 데이터를 넣고 빼어 사용해보자.
		//마숙
	}
	
	//공백상태인지 확인
	static boolean isEmpty() {
		return top == -1;
	}
	
	
	
	//배열형태로 만들어 놓았으니까 
	static boolean isFull() {
		return top == stack.length-1;
//		if(top == stack.length-1) return true;
//		return false;
	}
//	static boolean isFull() {
//		if(top == stack.length-1) return true;
//		else return false;
//	}
	
	static void stackPush(int value) {
		//푸쉬를 구현해본다.
		//가득 찼니? 물어보고 값을 넣느다.
	}
	
	static int stackPop() {
		//팝을 구현한다.
		//공백이니? 하고 물어보고 구현을 해야겠다.
		return 0;
	}
	
}
