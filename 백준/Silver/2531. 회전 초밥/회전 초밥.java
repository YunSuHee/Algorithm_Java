import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] belt = new int[n];//벨트위 정보
        int[] type;
        int maxType = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            belt[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n;i++){
            int temp =0;
            type =  new int[d+1];//가지수
            for(int j=0; j<k;j++){
                int index = (j+i)%n;
                type[belt[index]] +=1;
            }
            type[c] +=1;

            for(int j=0; j<=d;j++){
                if(type[j] >0){
                    temp++;
                }
            }
            if(temp>maxType) maxType = temp;
        }
        System.out.println(maxType);
    }
}