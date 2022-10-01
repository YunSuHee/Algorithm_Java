import java.util.Scanner;
//중복 조합
public class Main {
	static int n;
	static int m;
	static int[] num;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		num = new int[n];
		result = new int[m];
		
		for(int i=0;i<n;i++) {
			num[i] = i+1;
		}
		
		rcomb(0,0);
		System.out.println(sb);

	}
	
	static void rcomb(int idx, int cnt) {
		if(cnt == m) {
			for(int i: result) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}else if(idx == n) return;
		
		result[cnt] = num[idx];
		//현재 값을 다음번에 또 넣기
		rcomb(idx,cnt+1); //현재 값(idx)을 그대로 다음에(result의 cnt+1 인덱스)에 넣을 수 있고
		//다음 값을 현재에 또 넣기
		rcomb(idx+1,cnt); //다음 값을(idx+1) 현재에(result의 cnt+1인덱스) 넣을 수 있고  -> 현재 idx 번쨰 재료를 안뽑은 것
		
		
		//rcomb(idx+1, cnt+1); //다음 값(idx+1)을 다음에 넣을 수 있고  -> 이거 쓰면 중복
	}

}
