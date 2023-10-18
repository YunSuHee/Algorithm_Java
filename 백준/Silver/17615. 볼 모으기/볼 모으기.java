import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int red = 0;
        int blue = 0;
        for(int i=0; i<n; i++){
            if(balls.charAt(i)=='R'){
                red++;
            }else{
                blue++;
            }
        }

        int answer = Integer.MAX_VALUE;
        //1. 왼쪽으로 빨간 공 옮기는 경우
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(balls.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        answer = Math.min(red-cnt,answer);
        //2. 왼쪽으로 파란 공 옮기는 경우
        cnt = 0;
        for(int i=0; i<n; i++){
            if(balls.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }

        }
        answer = Math.min(answer,blue-cnt);

        //3. 오른쪽으로 빨간 공 옮기는 경우
        cnt = 0;
        for(int i=n-1; i>=0; i--){
            if(balls.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        answer = Math.min(answer,red-cnt);
        //4. 오른쪽으로 파란 공 옮기는 경우
        cnt = 0;
        for(int i=n-1; i>=0; i--){
            if(balls.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }
        }
        answer = Math.min(answer,blue-cnt);
        System.out.println(answer);

    }
}