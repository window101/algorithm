package programmers.problem35;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public long solution(long n) {
        long answer = 0;
        StringBuilder st = new StringBuilder();
        char [] arr = String.valueOf(n).toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(char c : arr) {
            pq.add(c -'0');
        }
        while(!pq.isEmpty()) {
            int tmp = pq.poll();
            st.append(tmp);
        }
        answer = Long.valueOf(st.toString());
        return answer;
    }
}
public class problem35 {
    public static void main(String[] args) {
        long n = 118372;
        Solution sol = new Solution();
        System.out.println(sol.solution(n));
    }
}
