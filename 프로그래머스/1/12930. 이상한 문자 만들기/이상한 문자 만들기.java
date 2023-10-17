class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<s.length();i++){
            if(i%2==0) answer.append(s.charAt(i).toUpperCase());
            else answer.append(s.charAt(i).toLowerCase());
        }
        return answer.toString();
    }
}