import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] buildings = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<w; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> queue = new LinkedList<>();
        int maxBuilding = 0;
        int answer = 0;
        for(int i=0; i<w; i++){
            if(maxBuilding == 0 && buildings[i] == 0 ) continue;
            if(maxBuilding <= buildings[i]){

                //queue에 있는 값 다 더하기
                while(!queue.isEmpty()){
                    answer += maxBuilding - queue.removeFirst();
                }
                maxBuilding = buildings[i];
                continue;
            }

            //마지막일때
            if(i == w-1){
                int minBuilding = buildings[i];
                while(!queue.isEmpty()){
                    int peekLast = queue.peekLast();
                    if(peekLast < minBuilding) answer += minBuilding - queue.removeLast();
                    else if(peekLast >= minBuilding){
                       minBuilding = queue.removeLast();
                    }

                }
            }

            if(maxBuilding != 0){
                queue.add(buildings[i]);
            }
        }

        System.out.println(answer);
    }
}