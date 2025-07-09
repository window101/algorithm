package programmers.problem7;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

public class problem7 {
    public static void main(String[] args) {
        int n = 10;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}
