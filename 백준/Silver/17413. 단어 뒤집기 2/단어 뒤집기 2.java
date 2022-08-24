import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String sen = sc.nextLine(); // nextLine으로 해야 한문장 다 받을 수 있음 next -> 단어 단위
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int i;
		
		for (i = 0; i < sen.length(); i++) {
			char letter = sen.charAt(i);

			if (letter == '<') {
				while (!stack.isEmpty()) { // 만약 <전 값들이 stack에 담아져 있으면 먼저 꺼낸 후 < 태그 후 값들을 넣기
					sb.append(stack.pop());
				}
				while (letter != '>') { //> 태그 전까지  값들을 넣기
					sb.append(letter);
					letter = sen.charAt(++i);
				}
				sb.append('>'); // > 추가 하기

			} else {
				if (letter == ' ') {// 만약 공백이라면 stack에 있는거 꺼내서 sb에 추가하기
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(" "); // 공백 추가
				} else {
					stack.add(letter);
				}
			}
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb.toString());
	}
}