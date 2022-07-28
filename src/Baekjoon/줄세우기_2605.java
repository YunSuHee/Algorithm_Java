package Baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 줄세우기_2605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// 학생 수
		int N = sc.nextInt();
		// 학생 객체
		List<Integer> student = new ArrayList<>();

		// i는 학생 순서이다. arraylist는 값이 있는 인덱스에 다른 값을 넣으면 인덱스가 하나씩 뒤로 밀린다.
		for (int i = 1; i < N + 1; i++) {
			int input = sc.nextInt();
			// 오른쪽이 앞이라고 생각하고 input 인덱스에 학생 순서인 i를 넣었다.
			student.add(input, i);
		} // 뒤에서부터 출력
		for (int i = N - 1; i >= 0; i--) {
			System.out.print(student.get(i) + " ");
		}
	}

}
