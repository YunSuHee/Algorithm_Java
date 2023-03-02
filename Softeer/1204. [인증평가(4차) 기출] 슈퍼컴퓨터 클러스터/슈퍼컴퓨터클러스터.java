package softeer;


import java.util.Arrays;
import java.util.Scanner;

public class 슈퍼컴퓨터클러스터 {

    public static void main(String[] args) {

        // 1. 성능이 가장 낮은 컴퓨터의 가능한 성능 범위는 컴퓨터 성능들의 최솟값 ~ 컴퓨터 성능들의 최댓값 + 예산 B의 제곱근
        // 2. 성능 범위를 이진 탐색으로 해서 가장 낮은 컴퓨터의 최대 성능을 찾자.
        // 3. 기준 값 ( 가장 낮은 컴퓨터 성능이라고 가정하는) - 원래 컴퓨터 성능 > 0 두개 뺀 값 만큼 성능을 올려줘야 함
        // 4. 그리고 cost(성능 증가 시켰을 때 드는 비용)에 두개 뺀 값의 제곱을 더해 준다.
        // 5. cost가 예산 보다 커지면 false(right를 mid -1) 아니면 true (left를 mid+1) -> answer에 업데이트

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 컴퓨터 수 1≤N≤10^5인 정수
        long b = sc.nextLong(); // 예산 1≤B≤10^18인 정수

        long[] computer = new long[n];

        for(int i=0; i<n; i++){
            computer[i] = sc.nextLong(); //컴퓨터 성능 ai 1≤N≤10^9인 정수
        }

        Arrays.sort(computer);
        // 제일 성능이 낮은 컴퓨터의 성능 최소, 최대값
        long min = computer[0];
        long max = computer[n-1] + (long)Math.sqrt(b);

        long answer = 0;

        //이분 탐색으로 제일 낮은 성능 컴퓨터 찾기
        while( min <= max){
            long mid = (min + max)/2;
            if(check(computer, mid, b)){ //예산을 더 키워도 된다
                min = mid +1;
                answer = mid;
            }else{
                max = mid -1 ;
            }
        }

        System.out.println(answer);

    }

    private static boolean check(long[] computer, long mid, long b) {
        long cost = 0;
        for(int i=0; i < computer.length ; i++){
            cost += mid - computer[i] > 0 ? Math.pow(mid-computer[i],2) : 0; // 성능 최소 값 - 지금 성능
            if(cost > b) return false;
        }
        return true;
    }
}
