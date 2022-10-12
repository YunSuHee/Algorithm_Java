package 수업_0919.powerset;

public class Powerset_비트마스킹 {
	static String[] 재료 = { "계란", "참치", "단무지" };
	static int N = 재료.length;

	public static void main(String[] args) {

		// 모든 경우의 수라는것은 이제 알았다....
		for (int i = 0; i < (1 << N); i++) {
			// i라는 김밥은 무슨김밥인데?
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) > 0) {
					System.out.print(재료[j]);
				}
			}
			System.out.println("김밥");

		}

	}
}
