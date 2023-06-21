import java.util.Scanner;

public class Main {
    //결과 저장하는 stringbuilder
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        check("",0);
        System.out.println(sb.toString());
    }

    static void check(String s, int cnt) {
        if(cnt == n){
            sb.append(s+'\n');
            return;
        }
        for(int i=1;i<=9; i++){
            //a+b는 문자열과 정수의 결합 연산을 의미합니다.
            // Java에서는 문자열과 다른 데이터 타입의 값을 + 연산자로 결합하면 문자열로 변환되어 연결됩니다.
            if(isPrime(Integer.parseInt(s+i))){
                check(s+i,cnt+1);
            }
        }
    }
    static boolean isPrime(int num){
        if(num == 1) return false;
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}