import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t = 1; t<= tc; t++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mask = (1<<n) -1 ; //m의 마지막 n개 비트를 확인하기 위한 비트 마스크
            int result = m & mask; //mask와 m을 and 연산하여 m의 마지막 n개 비트가 저장된다.

            if( mask == result) System.out.println("#"+t+ " ON");
            else System.out.println("#"+t+ " OFF");

        }
    }
}