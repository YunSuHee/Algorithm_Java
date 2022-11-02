import java.util.Scanner;

public class Main {

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      int startx = sc.nextInt();
      int starty = sc.nextInt();
      int dir = sc.nextInt();
      int clean = 0; // 몇번 청소했는지
      int[] dx = { -1, 0, 1, 0 }; // 0 북, 1 동, 2 남, 3 서
      int[] dy = { 0, 1, 0, -1 };

      int[][] robot = new int[n][m];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < m; j++) {
            robot[i][j] = sc.nextInt();
         }
      }

      loop : while (true) {
         // 현재 위치 청소
         if (robot[startx][starty] == 0) {
            robot[startx][starty] = 2;
            clean++;
         }

         for (int i = 0; i < 4; i++) {
            // 왼쪽 값 체크
            dir = (dir + 3) % 4;
            int nx = startx + dx[dir];
            int ny = starty + dy[dir];
            if (robot[nx][ny] == 0) {
            
               // 현재 위치 갱신
               startx = nx;
               starty = ny;
               continue loop;
            }
         }
         
         // 현재 dir의 반대 방향
         int oppdir = (dir + 2) % 4;
         int oppx = startx + dx[oppdir];
         int oppy = starty + dy[oppdir];

         // 후진 가능
         if (robot[oppx][oppy] != 1) {
            // 바라보는 방향은 그대로니까 dir은 변경하지 않고 로봇 청소기 위치만 바꿈
            startx = oppx;
            starty = oppy;
         } else {// 후진 불가능
            System.out.println(clean);
            System.exit(0);
         }
         

      }

   }

}