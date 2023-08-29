import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        char[] numbers = number.toCharArray();

        int startIdx = 0; //숫자 찾을때 범위의 시작점
        //answer 길이만큼 for문 돌아 앞에서부터 숫자 찾기
        for(int i=0; i<number.length()-k; i++){
            char max = 0;

            for(int j=startIdx; j<=k+i; j++){
                //가장 큰 수를 골라서 그 다음 인덱스를 시작인덱스로
                if(numbers[j]>max){
                    startIdx = j+1;
                    max = numbers[j];
                }
            }
            answer.append(max);
        }
             
        return answer.toString();
    }
}