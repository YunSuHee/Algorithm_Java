package swea;

import java.util.Scanner;

public class 단조증가 {

	public static void main(String[] args) {
		// Ai * Aj 를 곱합 값들을 배열에 넣고
		// 단조 증가인지 비교해서
		// max 값 찾기
		
		// Ai * Aj -> 한자리면 단조가 아니고 // 저건 조합으로.... 
		// Ai가 하나만 나올수도 있음
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i < T + 1; i++) {
			int max = -1;
			int N = sc.nextInt();
			int[] arr = new int[N];
			// Ai ~An 값들 담기
			for (int j = 0; j < N; j++) {
				int input = sc.nextInt();
				arr[j] = input;
			}
			
			if(N ==1) {
				String check=arr[0]+"";
				System.out.printf("#%d %d\n", T, findMax(check,max));
				
			}else {
				
				for (int k = 0; k < N-1 ; k++) {
					for(int l=k+1;l<N;l++) {
						
						String check = arr[k] * arr[l] + "";
						// 단조 증가인지 비교
						boolean num = false;
						
						for (int c = 0; c < check.length() - 1; c++) {
							if (check.charAt(c) < check.charAt(c + 1)) {
								num = true;							
							}
						}
						if (num) {
							max = Math.max(max, Integer.parseInt(check));
						}
					}
					
				}
				
				
				System.out.printf("#%d %d\n", T, max);
			}
		}

	}
	
	public static int findMax(String check,int max){
		
		boolean num = false;
		for (int c = 0; c < check.length() - 1; c++) {
			if (check.charAt(c) < check.charAt(c + 1)) {
				num = true;							
			}
		}
		if (num) {
			max = Math.max(max, Integer.parseInt(check));
		}
		return max;
	}
}