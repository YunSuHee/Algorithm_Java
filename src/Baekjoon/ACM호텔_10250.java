package Baekjoon;

import java.util.Scanner;

public class ACM호텔_10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 0; tc < t; tc++) {
			int H = sc.nextInt(); // 높이
			int W = sc.nextInt(); // 한 층에 방 개수
			int N = sc.nextInt(); //명수
			int temp =1;
			// 1 호부터  층별로 배당
			out: for(int i=1; i<=W;i++) {
				for(int j=1;j<=H; j++) {
					if(N == temp) {
						System.out.print(j);
						System.out.println(i<10 ? "0"+i : i); 
						break out;
					}temp++;
				}
			}
		}

	}

}
