import java.util.Arrays;

class Solution {
    static boolean check; //이진트리로 표현 가능한지 판별
    public int[] solution(long[] numbers) {

        int size = numbers.length;
        int[] answer = new int[size];

        for(int i=0; i<size; i++){
            

            //이진법으로 변환
            String decimal = Long.toBinaryString(numbers[i]);

            //포화이진트리 만들기 위한 원소 수 구하기
            int n = 0; //n승
            while(Math.pow(2,n)-1 < decimal.length()){
                n += 1;
            }
            //포화이진트리인지 확인 -> 아니면 0 추가
            if(Math.pow(2,n)-1 != decimal.length()){
                int addZero = (int) Math.pow(2,n)-1 - decimal.length();
                decimal = "0".repeat(addZero) + decimal;
            }

            //이진트리로 표현 가능한지 판별
            check = true;
            if(decimal.length() != 1) isPossible(decimal);

            if(check){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }

        }

        return answer;
    }

    private static void isPossible(String decimal) {
        if(!check) return;
        //가운데 글자 가져오기
        int middleIdx = decimal.length() /2;
        
        int middle = Integer.parseInt(decimal.substring(middleIdx,middleIdx+1));

        if(middle == 0){
            //decimal 전체가 영인지 확인
            boolean isZero = decimal.contains("1")  ? false : true;

            if(!isZero) check = false;
            return;


        }else{ //가운데가 1이면
            if(decimal.length() == 3) return;
            //좌 우 판별
            //좌
            isPossible(decimal.substring(0,middleIdx));
            //우
            isPossible(decimal.substring(middleIdx+1));

        }


    }
}
