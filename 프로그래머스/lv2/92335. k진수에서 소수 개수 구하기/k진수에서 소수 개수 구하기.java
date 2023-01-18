import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static Queue<Integer> queue = new LinkedList<>();
	static int answer = 0;

    public int solution(int n, int k) {
        // n을 k진법으로 변환
		String changeValue = Integer.toString(n, k);
		// System.out.println(changeValue);

		for (int i = 0; i < changeValue.length(); i++) {
			int isZero = changeValue.charAt(i) - '0';

			if (isZero != 0) { //0이 아니면 queue에 추가
				queue.add(isZero); 
			} else if (!queue.isEmpty()) { //0이고 queue가 비어있지 않으면
				isCheck(); //소수인지 확인

			}
		}
		if(!queue.isEmpty())isCheck();
        return answer;
    }
    
    private static void isCheck() {

		String check = "";
		while (!queue.isEmpty()) {
			check += queue.poll() + "";
		}

		if (isPrime(Long.parseLong(check))) {
			answer += 1;
		}

	}

	private static boolean isPrime(long check) {
		if (check == 1)
			return false;
		if (check == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(check); i++) {
			if (check % i == 0) {
				return false;
			}
		}
		return true;
	}
}