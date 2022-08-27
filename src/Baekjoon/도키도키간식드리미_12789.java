package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 도키도키간식드리미_12789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>(); //줄서있는 곳
		Stack<Integer> stack = new Stack<>(); // 대기하는 공간

		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}
		
		int now =1; //현재 순서세는 count 변수
		int count =0; //while 도는 회수
		
		while(true) {
			if(!queue.isEmpty() &&queue.peek() == now) {  //줄서는 곳 맨 앞사람이 now면 값을 제거 후 현재 순서 증가
				queue.poll(); 
				now++;

			}else if(!stack.isEmpty()&& stack.peek() == now){// 대기하는 공안 맨 앞사람이 now 값이면 제거후 현재 순서 증가
				stack.pop();
				now++;
			}else if(!queue.isEmpty()){ //줄서는 곳 맨앞사람이 now가 아니면 대기하는 공간으로 이동
				stack.add(queue.poll());
				
			}
			
			if(queue.isEmpty() && stack.isEmpty()){ //대기하는 공간과 줄서는 공간 모두 비어있으면 nice
				System.out.println("Nice");
				break;
			}else if(count>n*2 && (!queue.isEmpty() || !stack.isEmpty())) { // 둘중 하나 비어있지 않으면 sad // count는 이동할 수 있는 값 최대가 n*2이기 때문에 (줄서는 공간에서->대기하는 공간 -> 나가기 )
				System.out.println("Sad");
				break;
			}
			count++;
		}
	}

}
