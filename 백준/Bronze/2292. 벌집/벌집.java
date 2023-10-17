import java.util.*;
public class Main {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         
        int a = 1;
        int b = 1;
        int sum = 6;
        while(true) {
            if(n <= b) {
                break;
            }
             
            b += sum;
            sum += 6;
            a++;
        }
         
        System.out.println(a);
 
    }
 
}


