import java.util.Scanner;
import java.util.Stack;

public class Main {

	static Stack<Character> stack = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String line = sc.nextLine();
		String result = "";

		for (int i = 0; i < line.length(); i++) {
			if ((int) line.charAt(i) >= 65 && (int) line.charAt(i) <= 90) { // 알파벳이면 결과에 더한다.
				result += line.charAt(i);
			} else {														//연산자 일때
				if (stack.isEmpty()) {										//스택이 비어잇으면 현재 연산자를 추가한다.
					stack.add(line.charAt(i));
				} else {
					if (line.charAt(i) == ')') {							//)가 나오면 (나올때까지 연산자를 결과에 더해준다. 그리고 (괄호는 while문밖에서 pop 해서 버린다.
						while (stack.peek() != '(') {
							result += stack.pop();
						}
						stack.pop();
					} else if (line.charAt(i) == '(') {       				//( 괄호는 그냥 넣는다. -> 왜냐면 스택 밖에서는 우선순위가 제일 높기 떄문
						stack.add(line.charAt(i));
					} else if (operator(stack.peek()) < operator(line.charAt(i))) { // 지금들어오는 연산자가 stack의 제일 위 연산자보다 우선순위가 크면 stack에 넣는다.
						stack.add(line.charAt(i));
					} else {														//  지금들어오는 연산자가 stack의 제일 위 연산자보다 우선순위가 작거나 같으면 
						while (!stack.isEmpty() && operator(stack.peek()) >= operator(line.charAt(i))) { //큰거 나올때까지 stack의 값을 뺴서 결과에 추가한다. 단! stack이 비어있으면 안된다.
							result += stack.pop();
						}
						stack.add(line.charAt(i));                                 //그리고 현재 연산자를 stack에 넣어준다.
					}
				}
			}
		}
		while (!stack.isEmpty()) { //stack에 값이 없을떄까지 연산자를 뺴서 결과에 더해준다.
			result += stack.pop();
		}
		System.out.println(result);
	}

	static int operator(char oper) {
		int now = 0;

		if (oper == '*' || oper == '/') {
			now = 2;
		} else if (oper == '+' || oper == '-') {
			now = 1;
		}

		return now;
	}
}