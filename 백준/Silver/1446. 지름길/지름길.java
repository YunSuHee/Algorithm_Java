import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Road{
    int s,e,w;
    public Road(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w =w;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        
 //지름길을 찾을때 지름길 정보를 list에 넣어두고 시작점이 작은 순서대로 , 시작점이 같다면 끝이 작은 순서대로 정렬을 한다.
// 그리고 d+1까지 배열 dist를 만들어서 해당 거리에 올 수 있는 최소 값을 구한다.
// 현재 위치를 나타내는 move 변수와, 지름길 정보를 넣어둔 list을 순회하기 위한 idx 변수를 만든다.
// 그리고 배열에 지름길 최대 길이인 10000보다 하나큰 10001로 값을 채워준다.
// 현재 위치인 move 가 고속도로 끝인 d 보다 작을떄까지 while 문을 돈다.
// 지름길을 찾는 idx 가 지름길 정보가 들어있는 idx 보다 작아야 한다.
// 만약 지름길을 찾는 idx 가 정보가 들어있는 idx보다 크면 그냥 앞으로 한칸씩만 이동한다. -> 이때 한칸이동한 값은 원래 그 값에 있던 값과 전 값에서 +1 값 중에 더 작은 값을 넣어야 한다.
// 작다면 그 idx 에 해당하는  지름길 정보를 빼온다음 지름길 시작위치와 내 현재 위치와 같은지 본다. 만약 다르다면 위에처럼 한칸 이동하고
// 같다면 지름길 끝에 있는 점이 현재위치의 값+ 지름길로 이동한 거리 와 지름길 끝에 위치한 곳의 값과 비교해 작은 값을 넣는다.
// 이렇게 while문을 다 돈 후 dist[d]로 값을 찾는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        List<Road> data = new ArrayList<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            //역주행 불가
            if(e>d) continue;
            //지름길 아님
            if(e-s<=w) continue;
            data.add(new Road(s,e,w));

        }

        //시작점 기준으로 정렬 -> 시작 점이 같으면 실제 길이와 지름길 차이가 큰거
        Collections.sort(data, new Comparator<Road>(){
            public int compare(Road o1, Road o2){
                //시작점 -> 끝점
                if(o1.s == o2.s){
                    return o1.e- o2.e;
                }else{
                    return o1.s - o2.s;
                }

            }
        });
        int idx = 0;
        int move = 0;
        int[] dist = new int[d+1];
        Arrays.fill(dist,10001);
        dist[0] = 0;
        while(move<d){
            if(idx<data.size()){
                Road r = data.get(idx);
                if(r.s == move){
                    dist[r.e] = Math.min(dist[move]+r.w,dist[r.e]);
                    idx++;
                }else{
                    dist[move+1] = Math.min(dist[move]+1,dist[move+1]);
                    move++;
                }

            }else{
                dist[move+1] = Math.min(dist[move]+1,dist[move+1]);
                move++;
            }
        }

        System.out.println(dist[d]);



    }
}