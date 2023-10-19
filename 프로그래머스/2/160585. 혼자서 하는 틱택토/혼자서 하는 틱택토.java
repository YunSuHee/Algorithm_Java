class Solution {
    static char[][] map;
    public int solution(String[] board) {
        int answer = -1;
        map = new char[3][3];
        int o = 0;
        int x = 0;
        for(int i=0; i<3; i++){
            String a = board[i];
            for(int j=0; j<3; j++){
                map[i][j] = a.charAt(j);
                if(map[i][j] =='O') o++;
                else if(map[i][j]=='X') x++;
            }
        }
        if(x>o) return 0;
        if(o>x+1) return 0;
        if(check('O') && x==o) return 0;
        if(check('X') && o==x+1) return 0;
        if(check('O') &&check('X')) return 0;
        return 1;
//         //만약에 보드 판이 다 차있으면 
//         if(o+x==9){

//              //o가 한개 더 많아야 함
//              if(o==x+1){

//                 //만약에 빙고가 두개가 나오면 안됨
//                 if(check('O') && check('X')) return 0;

//                 //만약 x만 빙고가 나와도 안됨

//                 if(check('X')) return 0;
//                 return 1;
//             }else{
//                 return 0;
//              }
//         }
//        //만약 x랑 o 가 3보다 작으면
//         else if(x<3 && o<3){
//             //두개가 같으면 true 다르면 false
//                 if(o==x) return 1;
//                 if(o!=x+1) return 0;
//                 return 1;
//         }
//         //보드판이 다 안 찬 경우인데 세개 같은게 없는 경우
//         else{
            
//             //만약에 빙고가 두개가 나오면 안됨
//             if(check('O') && check('X')) return 0;
//             //o가 빙고일땐 무조건 o가 x보다 한개 커야함 
//             if(check('O') && o!=x+1) return 0;

//             //x가 빙고일땐 무조건 o와 x랑 개수가 같아야함
//             if(check('X')&& x!=o) return 0;
//             return 1;
//         }
        
    }
    static boolean check(char letter){
        //가로
        for(int i=0; i<3; i++){
            int cnt = 0;
            for(int j=0; j<3; j++){
                if(letter == map[i][j]) cnt++;
            }
            if(cnt == 3) return true;
        }
        //세로
        for(int i=0; i<3; i++){
            int cnt = 0;
            for(int j=0; j<3; j++){
                if(letter == map[j][i]) cnt++;
            }
            if(cnt ==3) return true;
        }
        //대각선
        if(map[0][0] == letter && map[1][1] == letter && map[2][2] == letter) return true;
         
        if(map[0][2] == letter && map[1][1] == letter && map[2][0] == letter) return true;
        return false;
    }
}