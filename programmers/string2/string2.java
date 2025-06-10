package programmers.string2;

class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if(s.length() == 4 || s.length() == 6) {
            boolean run = true;
            for(char c : s.toCharArray()) {
                if(!Character.isDigit(c)) {
                    run = false;
                    return run;
                }
            }
            answer = true;
        }
        return answer;
    }
}
public class string2 {
    public static void main(String[] args) {
        String s = "a234";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}
