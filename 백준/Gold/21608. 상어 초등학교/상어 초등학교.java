import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        //0. 좋아하는 학생 입력할 배열 선언 int[n^2+1][4], 배치 배열 선언
        //1. 학생 수만큼 반복문 돈다
        //1-1. 좋아하는 학생 check 하는 boolean 배열 선언
        //1-2. 학생번호 입력 받고, 좋아하는 학생번호 입력 받아 배열에 저장하고 check boolean 배열에 true 처리.
        //1-3. maxLike, x,y, maxBlank
        //1-4. n^2 반복문 돌면서 배치될 위치 찾는다.
        //1-4-0. blankcnt,likecnt,update = false 선언
        //1-4-1. 해당 위치가 비어 있지 않으면 continue. 비어있지 않으면 사방 탐색을 한다. for
        //1-4-1-1. 사방 탐색했을때 blankcnt 와 likecntt 를 센다.
        //1-4-2. if maxLike> likecnt-> update true
        //1-4-3. else if maxLike 와 likecnt 같은지 확인. 같으면 blankcnt check 한다 . maxBlank보다 커야한다.
        //1-4-4. update가 true면 x,y,maxLike,maxBlank 업데이트
        //1-5. x,y 위치에 학생번호 s를 넣어준다.  studnet[x][y] = s.
        //2.만족도 구한다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dx = {1,-1,0,0}; int[] dy = {0,0,1,-1};
        //0. 좋아하는 학생 입력할 배열 선언 int[n^2+1][4], 배치 배열 선언
        int[][] likeStudentInfo = new int[n*n+1][4]; //좋아하는 학생 정보
        int[][] student = new int[n+1][n+1]; //학생 자리 배치

        //1. 학생 수만큼 반복문 돈다
        for(int i=0; i<n*n; i++){
            //1-1. 좋아하는 학생 check 하는 boolean 배열 선언
            boolean[] check = new boolean[n*n+1];
            //1-2. 학생번호 입력 받고, 좋아하는 학생번호 입력 받아 배열에 저장하고 check boolean 배열에 true 처리.
            int s = sc.nextInt();
            for(int j = 0; j<4; j++){
                int tempLikeStudent = sc.nextInt();
                likeStudentInfo[s][j] = tempLikeStudent;
                check[tempLikeStudent] = true;
            }
            //1-3. maxLike, x,y, maxBlank
            int maxLike = 0; int x = 0; int y = 0; int maxBlank = 0;
            //1-4. n^2 반복문 돌면서 배치될 위치 찾는다.
            for(int k = 1; k < n+1; k++){
                for(int h = 1; h <n+1; h++){

                    //1-4-0. blankcnt,likecnt,update = false 선언
                    int blankCnt = 0; int likeCnt = 0; boolean update = false;
                    //1-4-1. 해당 위치가 비어 있지 않으면 continue. 비어있지 않으면 사방 탐색을 한다. for

                    if(student[k][h] != 0) continue;
                    if(x==0 && y==0) {//처음으로 비어있는 값을 시작점으로 설정
                        x = k;
                        y = h;
                    }
                    for(int l = 0; l<4; l++){
                        //1-4-1-1. 사방 탐색했을때 blankcnt 와 likecntt 를 센다.
                        int nx = k+dx[l];
                        int ny = h+dy[l];
                        if(nx>=1 && nx<n+1 && ny>=1 && ny<n+1){//범위에서 벗어나지 않아야함.
                            if(student[nx][ny] == 0) blankCnt ++;
                            if(check[student[nx][ny]]) likeCnt++;
                        }
                    }
                    //1-4-2. maxLike가 likecnt보다 크면 update true
                    if(maxLike < likeCnt){
                        update = true;
                        maxLike = likeCnt;
                        if(maxBlank < blankCnt) maxBlank = blankCnt;


                    }
                    //1-4-3. maxLike 와 likecnt 같은지 확인. 같으면 blankcnt check 한다 . maxBlank보다 커야한다.
                    else if(maxLike == likeCnt){
                        if(blankCnt>maxBlank) {
                            update = true;
                            maxBlank = blankCnt;
                        }
                    }

                    //1-4-4. update가 true면 x,y,maxLike,maxBlank 업데이트
                    if(update){
                        x = k;
                        y = h;
                        maxLike = likeCnt;
                        maxBlank = blankCnt;
                    }

                }
            }
            //1-5. x,y 위치에 학생번호 s를 넣어준다.
            student[x][y] = s;

        }

        //2. 만족도 확인
        int answer = 0;
        for(int i= 1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                int target = student[i][j];
                int cnt = 0;
                for(int l = 0; l<4; l++){
                    int nx = i+dx[l];
                    int ny = j+dy[l];
                    if(nx>=1 && nx<n+1 && ny>=1 && ny<n+1){//범위에서 벗어나지 않아야함.
                        int check = student[nx][ny];
                        for(int k=0; k<4;k++){
                            if(likeStudentInfo[target][k] == check) cnt++;
                        }
                    }
                }
                answer += cnt != 0 ? (int)Math.pow(10,cnt-1):0;
            }
        }
        System.out.println(answer);


    }
}