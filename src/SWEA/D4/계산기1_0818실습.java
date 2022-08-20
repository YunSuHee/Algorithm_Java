package SWEA.D4;

import java.util.Scanner;
import java.util.Stack;

public class 계산기1_0818실습 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int len = sc.nextInt();

			Stack<Character> stack = new Stack<Character>();

			String sen = sc.next();
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < len; i++) {
				char now = sen.charAt(i);

				if (now >= '0' && now <= '9') {
					sb.append(now);
				} else if (stack.isEmpty()) {
					stack.push(now); 

				} else {
					sb.append(stack.pop());
					stack.push(now);
				}

			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}

			Stack<Integer> stack2 = new Stack<Integer>();

			int total = 0;
			for (int i = 0; i < len; i++) {
				char now = sb.charAt(i);
				// System.out.println(now);
				if (now >= '0' && now <= '9') {
					stack2.push(now - '0');
				} else {
					int b = stack2.pop();
					int a = stack2.pop();
					int sum = a + b;
					stack2.push(sum);

				}
			}

			System.out.println("#" + t + " " + stack2.pop());

		}

	}

}