import java.util.*;
class Solution {
    public int solution(String name) {

        int updown = 0;
        //조이스틱이 움직이는 경우의 수 
        //1. 오른쪽 2. 오른쪽으로 갔다가 왼쪽 3. 왼쪽으로 갔다가 오른쪽 (중간에 방향을 트는걸 생각하지 못함)
        //중간에 연속된 A가 있을때 2번 3번처럼 이동해야 최소값이 나옴 
        //A가 끝나는 지점까지 이동하는데 걸리는 최소값 구함 (오른쪽 , 왼쪽 비교)
        //leftright의 디폴트는 오른쪽으로만 이동하는 경우를 넣어두고 2번과 3번중 최소값이 있으면 update
        int leftright = name.length()-1;
        
        for(int i=0; i<name.length();i++){
            //위아래로 움직이는 경우 count 해줌 
            //위로 조작하는 경우와 아래로 조작하는 경우 다 구하고 min하기
            char letter = name.charAt(i);
            updown += Math.min(letter-'A', 91-letter); //Z가 90이니까 91에서 빼기
            //우->좌 , 좌->우로 이동하는 경우 count
            //우 -> 좌 는 A가 나오기 전 idx *2 + (글자 길이 - 마지막 A idx)
            //좌 -> 우 는 A가 나오기 전 idx  + (글자 길이 - 마지막 A idx)*2
            //현재 값이 글자 길이 -1 보다 작고 다음값에 A가 있는 경우에만 해당! 아니면 그냥 오른쪽으로 쭉가면됨
            if(i < name.length()-1 && name.charAt(i+1) == 'A'){
                int endIdx = i+1;
                while(endIdx < name.length() && name.charAt(endIdx) == 'A') 
                    endIdx ++; //endIdx가 글자 길이만큼 되면  글자 길이 - 마지막 A idx를 할때 0이 되어 왼쪽으로만 가는 경우, 오른쪽으로만 가는 경우도 연출 가능

                int compare = Math.min(i*2+name.length()-endIdx,i+(name.length()-endIdx)*2);
                leftright = Math.min(leftright,compare);
            }

        }
        //위아래로 움직인 경우 + 좌우로 움직인 경우
        return updown+leftright;
    }
}