package programmers.problem2;

class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int exchanged = (n / a) * b;
            answer += exchanged ;
            n = (n/a)*b + n%a;
        }
        return answer;
    }
}
public class problem2 {
    public static void main(String[] args) {
        int a= 2;
        int b = 1;
        int n = 20;
        Solution sol = new Solution();
        System.out.println(sol.solution(a,b,n));
    }
}
