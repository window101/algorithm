package programmers.problem19;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p_cnt = 0;
        int y_cnt = 0;
        s = s.toLowerCase();
        for(char c : s.toCharArray()) {
            if(c == 'p') p_cnt++;
            if(c == 'y') y_cnt++;
        }
        if(p_cnt != y_cnt) {
            answer = false;
        }
        return answer;
    }
}
public class problem19 {
    public static void main(String[] args) {
        String s = "pPoooyY";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}
