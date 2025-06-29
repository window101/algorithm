package programmers.problem5;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a <= b) {
            for(int i = a; i<=b; i++) {
                answer += i;
            }
        }else {
            for(int i = b; i<=a; i++ ) {
                answer +=i;
            }
        } 
        return answer;
    }
}
public class problem5 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        Solution sol = new Solution();
        System.out.println(sol.solution(a,b));
    }
}
