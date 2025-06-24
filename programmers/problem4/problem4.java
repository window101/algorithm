package programmers.problem4;

import java.util.Arrays;

class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long tmp = x;
        for(int i = 0; i<n; i++) {
            answer[i] = tmp;
            tmp += x;
        }
        return answer;
    }
}
public class problem4 {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(x,n)));
    }
}
