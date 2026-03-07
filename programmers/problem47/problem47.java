package programmers.problem47;

class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int len = String.valueOf(x).length();
        int sum = 0;
        int tmp = x;
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        if(x % sum == 0) {
            answer = true;
        }
        return answer;
    }
}
public class problem47 {
    public static void main(String[] args) {
        int x = 11;
        Solution sol = new Solution();
        System.out.println(sol.solution(x));
    }
}
