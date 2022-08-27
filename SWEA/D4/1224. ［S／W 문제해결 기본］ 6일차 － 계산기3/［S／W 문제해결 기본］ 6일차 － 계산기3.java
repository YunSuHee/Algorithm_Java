
import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int len = sc.nextInt(); // 연산 길이

			StringBuffer sb = new StringBuffer(); //후위 표기법 
			Stack<Character> sOper = new Stack<Character>(); //연산자 담을 stack

			String sen = sc.next();

			for (int i = 0; i < len; i++) {
				char now = sen.charAt(i);

				if (now >= '0' && now <= '9') { //숫자 일 경우 stringbuffer에 넣기
					sb.append(now);
				} else if (sOper.isEmpty()) { // stack이 비어있으면 무조건 연산자 하나는 넣기
					sOper.add(now);

				} else { //연잔자 일 경우
					if(now == '(') sOper.push(now); //'('는 무조건 넣어 왜냐면 stack 밖에서는 우선순위가 3이기 때문
					else if(now == ')') { //'('가 나올때 까지 pop
						while(sOper.peek() != '(') {
							sb.append(sOper.pop());
						}
						sOper.pop(); // '('는 pop 해서 버려
					}else {
						// 현재 연산자 우선순위가 더 크면 스택에 넣어서 누름
						if(prior(sOper.peek())<prior(now)) { //외부'('는 3이지만 앞에 if문에서 거르기때문에 문제 되지 않음
							sOper.push(now);
						}else{                               //prior(sOper.peek())>=prior(now)
							while(prior(sOper.peek())>=prior(now)) {
								sb.append(sOper.pop());
							} 
							sOper.push(now); //현재가 더 큰 경우 push
						}
						
						//위에 if else 말고 아래처럼 작성하면 더 편함 위에 
//						while(prior(sOper.peek())>=prior(now)) {
//							sb.append(sOper.pop());
//						} 
//						sOper.push(now); //현재가 더 큰 경우 push
						
						
					}
				}

			} // for문이 끝나면  stack 빌때까지 sb에 추가
			while (!sOper.isEmpty()) {
				sb.append(sOper.pop());
			}

			//후위 연산 계산 시작
			Stack<Integer> cal = new Stack<Integer>(); //계산하는 후위연산 -> 숫자 넣기

			for (int i = 0; i < sb.length(); i++) {  // len 하면 안됨!! 괄호들이 다 빠졌으니까 sb의 길이
				char now = sb.charAt(i);

				if (now >= '0' && now <= '9') {
					cal.push(now-'0');
				} else {
					int b = cal.pop();
					int a = cal.pop();
					if(now == '*') cal.push(a*b);
					else if(now == '+') cal.push(a+b);

				}
			}

			System.out.println("#" + t + " " + cal.pop()); // 마지막에 값 출력

		}

	}
	
	static int prior(char operator) {
		
		if(operator == '+' || operator == '-') return 1;
		if(operator == '*' || operator == '/') return 2;
		
		return 0; // '('가 stack 안에 있을때엔 우선 순위 0
	}

}