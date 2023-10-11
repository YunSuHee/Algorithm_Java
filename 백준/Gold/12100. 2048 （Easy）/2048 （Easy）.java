import java.util.Scanner;

public class Main {
    static int n;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        direction(map,0); //상(0) 하(1) 좌(2) 우(3)
        //최대값 찾기
        System.out.println(answer);
    }
    static void direction (int[][] map,  int depth){
        if(depth == 5){
            answer = Math.max(findMax(map),answer);
            return;
        }

        for(int dir=0; dir<4; dir++){
            int[][] newMap = new int[n][n];
            for(int i = 0; i < n; i++) {
                newMap[i] = map[i].clone();
            }
            direction(move(newMap,dir),depth+1);
        }

    }

    static int findMax(int[][] map){
        int temp = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                temp = Math.max(map[i][j],temp);
            }
        }
        return temp;
    }

    static int[][] move(int[][] map,int dir){
        if(dir == 0){
            for(int i=0; i<n; i++){
                //1. 전부 위로 밀기
                int idx = 0;
                for(int j=0; j<n; j++){
                    if(map[j][i] !=0){
                        int temp = map[j][i];
                        map[j][i] = 0;
                        map[idx][i] = temp;
                        idx++;

                    }
                }
                //2. 합치기
                for(int j=0; j<n-1; j++){
                    if(map[j][i] == map[j+1][i]){
                        map[j][i] *= 2;
                        map[j+1][i] = 0;
                    }
                }
                //3. 전부 위로 밀기
                idx = 0;
                for(int j=0; j<n; j++){
                    if(map[j][i] !=0){
                        int temp = map[j][i];
                        map[j][i] = 0;
                        map[idx][i] = temp;
                        idx++;

                    }
                }
            }
        }else if (dir == 1){ //하
            for(int i=0; i<n; i++){
                //1.전부 아래로 밀기
                int idx = n-1;
                for(int j= n-1; j>=0; j--){
                    if(map[j][i] !=0){
                        int temp = map[j][i];
                        map[j][i] = 0;
                        map[idx][i] = temp;
                        idx--;

                    }
                }
                //2.합치기
                for(int j= n-1; j>0; j--){
                    if(map[j][i] == map[j-1][i]){
                        map[j][i] *= 2;
                        map[j-1][i] = 0;
                    }
                }
                //3.전부 아래로 밀기
                idx = n-1;
                for(int j= n-1; j>=0; j--){
                    if(map[j][i] !=0){
                        int temp = map[j][i];
                        map[j][i] = 0;
                        map[idx][i] = temp;
                        idx--;

                    }
                }
            }
        }else if (dir == 2){ //좌
            for(int i=0; i<n; i++){
                //1. 전부 좌로 밀기
                int idx = 0;
                for(int j=0; j<n; j++){
                    if(map[i][j] !=0){
                        int temp = map[i][j];
                        map[i][j] = 0;
                        map[i][idx] = temp;
                        idx++;

                    }
                }
                //2. 합치기
                for(int j=0; j<n-1; j++){
                    if(map[i][j] == map[i][j+1]){
                        map[i][j] *= 2;
                        map[i][j+1] = 0;
                    }
                }
                //3. 전부 좌로 밀기
                idx = 0;
                for(int j=0; j<n; j++){
                    if(map[i][j] !=0){
                        int temp = map[i][j];
                        map[i][j] = 0;
                        map[i][idx] = temp;
                        idx++;

                    }
                }
            }
        }else if (dir == 3){
            for(int i=0; i<n; i++){
                //1.전부 오른쪽로 밀기
                int idx = n-1;
                for(int j= n-1; j>=0; j--){
                    if(map[i][j] !=0){
                        int temp = map[i][j];
                        map[i][j] = 0;
                        map[i][idx] = temp;
                        idx--;

                    }
                }
                //2.합치기
                for(int j= n-1; j>0; j--){
                    if(map[i][j] == map[i][j-1]){
                        map[i][j] *= 2;
                        map[i][j-1] = 0;
                    }
                }
                //3.전부 오른쪽으로 밀기
                idx = n-1;
                for(int j= n-1; j>=0; j--){
                    if(map[i][j] !=0){
                        int temp = map[i][j];
                        map[i][j] = 0;
                        map[i][idx] = temp;
                        idx--;

                    }
                }
            }
        }

        return map;
    }


}