package programmers.problem9;

class Solution {
    public long solution(long n) {
        long x = (long)Math.sqrt(n);
        if(x *x == n) {
            return (x+1) * (x+1);
        }else {
            return -1;
        }
    }
}
public class problem9 {
    public static void main(String[] args) {
        int n = 121;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}
