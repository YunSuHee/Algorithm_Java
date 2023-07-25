import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(pow(a,b,c));
    }
    static long pow(int a, int b, int c){
        if(b == 1) return a%c;

        long temp = pow(a,b/2,c);
        if(b%2 == 1){
            return temp*temp%c*a%c;
        }
        return temp*temp%c;
    }
}