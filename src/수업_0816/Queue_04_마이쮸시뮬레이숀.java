package 수업_0816;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_04_마이쮸시뮬레이숀 {
	static class Person {
		int num; // 몇번인지
		int cnt; // 몇개 가져갔는지

		public Person(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) {
		Queue<Person> queue = new LinkedList<>();
		int N = 20; // 마이쮸 갯수가 20개다.
		int pNum = 1;

		while (N > 0) {
			// 코드로 작성을 해볼것.!!!!
			// 1번 사람부터 받기 시작한다. 처음에는 1개를 받고, 이후 줄을 설때마다 한개씩 늘어난다.
			// 한명이 마이쮸를 받고 뒤로 가서 줄을 서게 된다면 새로운 번호를 가진 사람이 추가되어 줄을 서게 된다.

			// 현재 남아있는 마이쮸의 갯수는 OO개 / O번이 O개 가져갔음.

		}

		// 마지막으로 마이쮸를 다털어간 사람은 OO번이고 이때는 O개를 가져갔다.

	}// main
}
