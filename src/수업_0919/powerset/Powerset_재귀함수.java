package 수업_0919.powerset;

public class Powerset_재귀함수 {
	
	
	static String[] 재료 = { "계란", "참치", "단무지" };
	static int N = 재료.length;

	static boolean[] sel = new boolean[N];

	public static void main(String[] args) {
		powerset(0);
	}

	// idx : 해당 위치의 재료를 넣을지 말지에 대해 판단하겠다.
	static void powerset(int idx) {
		// 탈출부 , 기저조건, base 케이스 : 김밥 말기
		if (idx == N) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < N; i++) {
				if (sel[i])
					sb.append(재료[i]);
			}
			System.out.println(sb+"김밥");
		} else {
			sel[idx] = false; // 해당 재료를 빼고 갈래
			powerset(idx + 1); // 다음재료로 넘어가기도 하고 기저조건으로 가게 유도
			sel[idx] = true;
			powerset(idx + 1);
		}

		// 유도조건, recursive 케이스 ... : 재료선정
	}
}
