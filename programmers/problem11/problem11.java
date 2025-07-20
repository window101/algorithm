package programmers.problem11;

import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int y = 3; y<=total; y++) {
            if(total % y != 0) {
                continue;
            }
            int x = total / y;
            if(y > x) continue;
            if((x - 2) *(y - 2) == yellow) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}

public class problem11 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(brown, yellow)));
    }
}
