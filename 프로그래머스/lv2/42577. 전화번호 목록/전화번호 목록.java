import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {

        Set<String> number = new HashSet<>();
        for(String n : phone_book){
            number.add(n);
        }
        //System.out.println(number);
        
        for(String n : phone_book){
            for(int i = 1; i < n.length(); i++){
                if(number.contains(n.substring(0,i))){
                    return false;
                }
            }
        }
        
        return true;
    }
}