package programmers.problem50;

import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        if(list.size() == 0) {
            return new int[] {-1};
        }
        Collections.sort(list); 
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
public class problem50 {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 9, 7, 10};
        int divisor = 5;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(arr, divisor)));
    }
}
