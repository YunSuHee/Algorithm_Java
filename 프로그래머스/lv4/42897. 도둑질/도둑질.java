import java.util.*;
class Solution {
    public int solution(int[] money) {
        int size = money.length;
        //원형일 때는 적절히 0을 넣고, 적절히 쪼개봐라
        //원형 배열이므로 배열을 두개로 쪼개자
        int[] dp_a = new int[size-1]; //마지막 집 뺀 배열 
        int[] dp_b = new int[size-1]; //처음 집 뺀 배열 그래서 시작점이 i+1
        dp_a[0] = money[0];
        dp_b[0] = money[1];
        for(int i=1; i<size-1; i++){
            //money 배열 조회할때 index
            int aIndex = i;
            int bIndex = i+1;
            if(i==1){
                //두번째 집은 첫번째 집하고만 비교하면 됨
                dp_a[i] = Math.max(dp_a[i-1],money[aIndex]);
                dp_b[i] = Math.max(dp_b[i-1],money[bIndex]); //dp_b는 처음집을 뺏으니 i+1
            }else{
                //점화식은 전위치의 dp 값과 전전위치의 dp + 내 위치의 값을 비교해서 큰거
                dp_a[i] = Math.max(dp_a[i-1],money[aIndex]+dp_a[i-2]);
                dp_b[i] = Math.max(dp_b[i-1],money[bIndex]+dp_b[i-2]);
            }
        }
        
        return Math.max(dp_a[size-2],dp_b[size-2]);
    }
}