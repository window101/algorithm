package programmers.problem1;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i<=n; i++) {
            if(n % i == 0) {
                answer += i;
            }
        }
        
        return answer;
    }
}
public class problem1 {
    public static void main(String[] args) {
        int n = 12;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}
