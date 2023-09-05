import java.util.*;
class Solution {
    public int solution(int N, int number) {
        //N의 사용횟수 별로 list를 만들고 list는 set으로 구성
        List<HashSet<Integer>> list = new ArrayList<>();
        for(int i=0; i<=8;i++){
            list.add(new HashSet<>());
        }
        //number가 N인 경우 사용횟수가 1
        list.get(1).add(N);
        if(number == N) return 1;
        
        //숫자 사용횟수가 2일때부터 탐색
        for(int i=2; i<=8; i++){
            
            //이전 사용횟수들로 경우의 수 찾기
            for(int j=1; j<i; j++){
                HashSet<Integer> a = list.get(j);
                HashSet<Integer> b = list.get(i-j);
                
                for(int x : a){
                    for(int y :b){
                        list.get(i).add(x+y);
                        list.get(i).add(x-y);
                        list.get(i).add(x*y);
                        if(x!=0 && y!=0) list.get(i).add(x/y);
                        
                    }
                }
            }
            list.get(i).add(Integer.parseInt((N+"").repeat(i)));
            if(list.get(i).contains(number)) return i;
        }

        return -1;
    }
}