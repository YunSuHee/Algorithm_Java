import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int answer = Integer.MAX_VALUE;
        //1. 왼쪽으로 빨간 공 옮기는 경우
        int cnt = 0;
        boolean isJump = false;
        for(int i=0; i<n; i++){
            if(balls.charAt(i)=='R' && isJump){
                cnt++;
            }
            if(balls.charAt(i)=='B') isJump = true;
        }
        answer = Math.min(cnt,answer);
        //2. 왼쪽으로 파란 공 옮기는 경우
        cnt = 0;
        isJump = false;
        for(int i=0; i<n; i++){
            if(balls.charAt(i)=='B' && isJump){
                cnt++;
            }
            if(balls.charAt(i)=='R') isJump = true;
        }
        answer = Math.min(answer,cnt);
        //3. 오른쪽으로 빨간 공 옮기는 경우
        cnt = 0;
        isJump = false;
        for(int i=n-1; i>=0; i--){
            if(balls.charAt(i)=='R'&&isJump){
                cnt++;
            }
            if(balls.charAt(i)=='B') isJump = true;
        }
        answer = Math.min(answer,cnt);

        //4. 오른쪽으로 파란 공 옮기는 경우
        cnt = 0;
        isJump = false;
        for(int i=n-1; i>=0; i--){
            if(balls.charAt(i)=='B' && isJump){
                cnt++;
            }
            if(balls.charAt(i)=='R') isJump = true;
        }
        answer = Math.min(answer,cnt);
        System.out.println(answer);

    }
}