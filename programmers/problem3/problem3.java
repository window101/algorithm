package programmers.problem3;

class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int mid = len / 2;
        if (len % 2 == 0) {
            // 짝수: 가운데 두 글자
            answer = s.substring(mid - 1, mid + 1);
        } else {
            // 홀수: 가운데 한 글자
            answer = s.substring(mid, mid + 1);
        }
        return answer;
    }
}

public class problem3 {
    public static void main(String[] args) {
        String s = "abcde";
        Solution sol = new Solution();
        System.out.println(sol.solution(s));
    }
}
