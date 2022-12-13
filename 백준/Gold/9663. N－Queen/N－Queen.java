import java.util.Scanner;

public class Main {

    static int N;
    static int answer;
    static int[][] map;

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       N = sc.nextInt();
       map = new int[N][N];

       queen(0);
        System.out.println(answer);

    }
    static void queen(int cnt){
        //기저조건
        if(cnt == N){ //끝줄에 QUEEN 이 들어오면 CNT+1 값을 QUEEN 메소드에 넣는다. 시작이 0이었으니 기저조건은 CNT == N
            answer+=1;
            return;
        }
        for(int i=0; i<N; i++){
            //퀸이 들어올 수 있다면
            if(isQueen(cnt,i)){
                //queen 위치 표시
                map[cnt][i] = 1;
                //다음줄 퀸 위치
                queen(cnt+1);
                //재귀가 끝나고 현재 자리 다시 reset
                map[cnt][i] =0;
            }
        }
    }
    static boolean isQueen(int r, int c){
        int left = c;
        int right = c;

        for(int i=r-1; i>=0;i--){ //현재 row 보다 위에 값들
            left --;
            right ++;
            if(map[i][c] == 1) return false;
            if(left >= 0 && map[i][left] ==1 ) return false;
            if(right <N && map[i][right] == 1) return false;
        }
        return true;
    }
}
