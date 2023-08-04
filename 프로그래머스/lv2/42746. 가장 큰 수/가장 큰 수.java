import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        String[] n = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            n[i] = numbers[i]+"";
        }
        Arrays.sort(n,(o1,o2)->(o2+o1).compareTo(o1+o2));

        // Arrays.sort(n,new Comparator<String>(){
        //     public int compare(String s1, String s2){
        //         return (s2+s1).compareTo(s1+s2);
        //     }
        // });
        if(n[0].equals("0")) return "0";
        for(String s : n){
            sb.append(s);
        }
        return sb.toString();
    }
}