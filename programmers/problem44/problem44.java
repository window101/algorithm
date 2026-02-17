package programmers.problem44;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int minVal = Integer.MAX_VALUE;
        if(arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        for(int i : arr) {
            if(i < minVal) {
                minVal = i;
            }
        }
        int cnt = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == minVal) continue;
            answer[cnt] = arr[i];
            cnt++;
        }
        return answer;
    }
}
public class problem44 {
    public static void main(String[] args) {
        int[] arr = new int[] {10};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(arr)));
    }
}
