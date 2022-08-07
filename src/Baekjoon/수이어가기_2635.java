package Baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class 수이어가기_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		// 최종 출력될 리스트;
		ArrayList<Integer> result = new ArrayList<>();
		//ArrayList<Integer> temp = new ArrayList<>();
		
		int maxNum =0;
		for (int i = input; i > 0; i--) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(input);
			temp.add(i);

			for(int j =0; j<temp.size()-1;j++) {
				//음의 정수가 아닐때니까 0도 포함
				if(temp.get(j)-temp.get(j+1)>=0) {
					temp.add(temp.get(j)-temp.get(j+1));
				}
			}
			
			if(temp.size()>maxNum) {
				maxNum = temp.size();
				//temp 리스트가 for문 밖에 있을 때 result 리스트로 깊은 복사하기 // 기존 리스트 초기화하고
//				result.clear();
//				result = (ArrayList<Integer>) temp.clone();
				
				//temp 리스트가 for문 안에 있을때엔 얕은 복사로 리스트 복사가능
				result = temp;
				
				
			}

			
		}
		System.out.println(maxNum);
		for(int i: result) {
			System.out.print(i+" ");
		}

	}

}
