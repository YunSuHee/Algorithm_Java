import java.util.Scanner;

public class Main {
    static boolean result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            result = true;
            String input = sc.next();
            check(input);

            System.out.println(result ? "YES" : "NO");

        }
    }

    private static void check(String input) {

        if (!result) return;
        if(input.length() == 1) return;

        char[] fold = input.toCharArray();
        int mid = fold.length / 2;
        int left = mid - 1;
        int right = mid + 1;

        while (left >= 0) {
            if (fold[left] != fold[right]) {
                left -= 1;
                right += 1;
            } else {
                result = false;
                return;
            }
        }
        check(input.substring(0, mid));
        check(input.substring(mid + 1));

    }
}
