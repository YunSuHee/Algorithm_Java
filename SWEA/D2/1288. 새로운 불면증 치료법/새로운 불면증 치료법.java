
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int total = (1 << 10) -1; //모든 숫자가 등장했을 때의 값
        for(int t = 1; t<= tc; t++){
            int n = sc . nextInt(); //입력된 수

            int visited = 0; //현재까지 본 숫자들을 bit 로 표현한 수, ex) 3,7,9 => 1010001000(2)
            int count = 0; //이때까지 본 수의 개수 (N * count) 까지 봤다. -> 양을 세는거니까 출력할때는 n * count
            for(count =1;;count++){
                char[] arr = String.valueOf(n * count).toCharArray(); //n * count  값을 문자열로 표현한 것 (예 : 5*13 = 65 =>"65")
                for(char c : arr){
                    int num = c -'0'; //char를 수로 바꾸고
                    visited = visited | (1<<num); //각 숫자에 대해 등장했다는 의미로 bit를 1로 변경
                }
                if(total == visited) break; //모든 숫자가 등장했다면 종료
            }

            System.out.println("#"+t+" "+count * n);
        }


    }
}
