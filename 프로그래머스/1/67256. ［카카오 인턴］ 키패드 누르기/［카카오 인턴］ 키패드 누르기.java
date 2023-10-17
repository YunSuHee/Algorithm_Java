import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int[][] key = new int[4][3];
        int temp = 1;
        Pos right = new Pos(3,2);
        Pos left = new Pos(3,0);
        
        for(int i=0; i<3;i++){
            for(int j=0; j<3; j++){
                key[i][j] = temp++;
            }
        }
        for(int i : numbers){

            if(i%3 == 1){ //왼쪽
                sb.append("L");
                left= new Pos(i/3,0);

            }else if(i!=0 && i%3 == 0){ //오른쪽
                sb.append("R");
                right = new Pos(i/3-1,2);

            }else{//가까운곳

                int x = i==0? 3:i/3;
                int y = 1;
                boolean r = false;
                boolean l = false;
                int Rgab = Math.abs(x-right.x)+ Math.abs(y-right.y);
                int Lgab = Math.abs(x-left.x)+ Math.abs(y-left.y);
                if(Rgab>Lgab){
                    l = true;
                }else if(Rgab<Lgab){
                    r = true;
                }

                if(!(r||l)){
                    if(hand.equals("right")){
                        l = false; 
                        r = true;
                    }else{
                        l = true;
                        r = false;
                    }

                }
                if(r){
                    right = new Pos(x,y);
                    sb.append("R");
                }
                if(l){
                    left = new Pos(x,y);
                    sb.append("L");
                }

            }
        }

        return sb.toString();
    }
}
class Pos{
    int x;
    int y;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}