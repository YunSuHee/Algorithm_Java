package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class 종이자르기_2628 {

	public static void main(String[] args) {
		// 가로 세로 에서 잘린 범위가 가장 큰 두부분의 곱
		// 가로  0 세로  1
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> rowList = new ArrayList<>();
		ArrayList<Integer> colList = new ArrayList<>();

		int row = sc.nextInt(); // 가로지만  1에 넣기 - 세로 자를때 길이
		int col = sc.nextInt(); // 세로지만  0에 넣기 - 가로 자를때 길이

		rowList.add(0); rowList.add(col);
		colList.add(0); colList.add(row);

		int cutNum = sc.nextInt();
		for (int i = 0; i < cutNum; i++) {
			int rowcol = sc.nextInt();
			int lineNum = sc.nextInt();
			if (rowcol == 0) {
				rowList.add(lineNum);
			} else if (rowcol == 1) {
				colList.add(lineNum);
			}
		}

		Collections.sort(rowList);
		Collections.sort(colList);

		int maxRow = 0;
		int maxCol = 0;

		for (int i = 0; i < rowList.size() - 1; i++) {
			int temp = rowList.get(i + 1) - rowList.get(i);
			if (maxRow < temp) {
				maxRow = temp;
			}
		}

		for (int i = 0; i < colList.size() - 1; i++) {
			int temp = colList.get(i + 1) - colList.get(i);
			if (maxCol < temp) {
				maxCol = temp;
			}
		}

		System.out.println(maxRow * maxCol);

	}

}
