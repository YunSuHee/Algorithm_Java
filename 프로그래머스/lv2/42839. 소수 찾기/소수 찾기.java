import java.util.*;
class Solution {
    static char[] number;
    static boolean[] check;
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        //1. numbers 쪼개서 char에 넣기
        //2. 순열로 수 만들기
        //3. 그 수가 prime 이면 set에 넣기
        
        number = new char[numbers.length()];
        check = new boolean[numbers.length()];
        
        for(int i=0; i< numbers.length(); i++){
            number[i] = numbers.charAt(i);
        }
        System.out.println(Arrays.toString(number));
        
        String out = "";
        permutation(out,0);
        
        return set.size();
    }
    void permutation(String out,int idx){

        //소수인지 확인
        if(out != ""){
            if(isPrime(Integer.parseInt(out))){
              set.add(Integer.parseInt(out));
            } 
        }
        if(idx == number.length) return;
        for(int i=0; i<number.length; i++){
            if(!check[i]){
                String temp = out+number[i];                
                check[i] = true;
                permutation(temp,idx+1);
                check[i] = false;
            }
        }
    }
    boolean isPrime(int num){
        if(num ==0 || num == 1) return false;
        for(int i=2; i<=Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}