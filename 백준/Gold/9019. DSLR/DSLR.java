import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static class Number{
        int num;
        String result;
        public Number(int num, String result){
            this.num = num;
            this.result = result;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int tc = 0; tc < t; tc++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            boolean[] check = new boolean[10000];

            //bfs 시작
            Queue<Number> q = new LinkedList<>();
            check[a] = true;
            q.add(new Number(a,""));

            char[] order = { 'D', 'S', 'L', 'R' };

            out:while(!q.isEmpty()){

                Number data= q.poll();
                int value = data.num;
                String command = data.result;

                for(int i=0; i<4; i++){
                    int num = changeNum(value, i);
                    //바뀐 값이 정답과 일치하면 종료
                    if(num == b){
                        System.out.println(command+order[i]);
                        break out;
                    }
                    //이미 나왔던 값이면 pass
                    if(check[num]) continue ;
                    //나온적 없는 값이라면 방문 처리 후 queue에 값 추가
                    check[num] = true;
                    q.add(new Number(num,command+order[i]));
                }


            }

        }

    }
        static int changeNum(int cur,int oper){ //현재 값과 명령어를 매개변수로
            int num = 0;
            int tempA, tempB;
            switch (oper){
                case 0: //d
                    num = (cur*2)%10000;
                    break;
                case 1: //s
                    num = cur - 1 == -1? 9999 : cur -1;
                    break;
                case 2: //l
                    //1000으로 나눴을때 몫이 맨뒤로 가고 나머지는 앞으로 이동
                    tempA = cur/1000;
                    tempB = cur%1000;
                    num = tempB*10 + tempA;
                    break;
                case 3: //r
                    //10으로 나눴을때 몫이 뒤로 가고 나머지는 앞으로 이동
                    tempA = cur/10;
                    tempB = cur%10;
                    num = tempB*1000+ tempA;
                    break;
            }

            return num;

        }
}