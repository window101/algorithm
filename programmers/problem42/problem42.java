package programmers.problem42;

import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a,b) -> {
            if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        long bomb = Long.MIN_VALUE;
        for(int[] t : targets) {
            long s2 = 2*t[0];
            long e2 = 2*t[1];
            if(bomb <= s2) {
                bomb = e2-1;
                answer++;    
            }
        }
        return answer;
    }
}
public class problem42 {
    public static void main(String[] args) {
        int[][] targets = new int[][] {{4,5}, {4,8}, {10,14}, {11,13}, {5,12}, {3,7}, {1,4}};
        Solution sol = new Solution();
        System.out.println(sol.solution(targets));
    }
}