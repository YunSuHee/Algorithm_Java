import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            String[] arr = br.readLine().split("");
            TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
            int x = n/4;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<x;i++){ //회전 수
                for(int j=0; j<4; j++){//묶음 단위
                    for(int l=0; l<x; l++){//단어 수
                        int index = -1*i +j*x + l;
                        if(index <0) index += n;
                        else index %= n;
                        sb.append(arr[index]);
                    }
                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }
            String[] answer = set.toArray(new String[set.size()]);

            System.out.println("#"+t+" "+Integer.parseInt(answer[k-1],16));


        }
    }
}