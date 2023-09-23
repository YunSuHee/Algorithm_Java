import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] check = new int[100001];
        boolean[] visit = new boolean[100001];
        visit[n]= true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while(!queue.isEmpty()){
            int now = queue.poll();

            if(now == k){
                System.out.println(check[k]);
                break;
            }
            if(now*2<=100000 && !visit[now*2]){
                queue.add(now*2);
                check[now*2] = check[now];
                visit[now*2] = true;
            }
            if(now-1>=0 &&!visit[now-1]){
                queue.add(now-1);
                check[now-1] = check[now] +1;
                visit[now-1] = true;
            }
            if(now+1<=100000 &&!visit[now+1]){
                queue.add(now+1);
                check[now+1] = check[now] +1;
                visit[now+1] = true;
            }
            if(now*2<=100000 && !visit[now*2]){
                queue.add(now*2);
                check[now*2] = check[now];
                visit[now*2] = true;
            }
        }
    }
}