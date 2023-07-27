import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int prev = 0;
            for(int i=1;;i++){
                prev = (10*prev +1)%n;
                if(prev == 0){
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}