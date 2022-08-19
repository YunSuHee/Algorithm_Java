import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int len = sc.nextInt();
            ArrayList<Integer> code = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                code.add(sc.nextInt());
            }
 
            int command = sc.nextInt();
 
            for (int i = 0; i < command; i++) {
                String start = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
 
                for (int j = x; j < x+y; j++) {
 
                    code.add(j, sc.nextInt()); // 값 변경
                }
            }
 
            System.out.print("#" + t);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + code.get(i));
            }
            System.out.println();
        }
    }
 
}